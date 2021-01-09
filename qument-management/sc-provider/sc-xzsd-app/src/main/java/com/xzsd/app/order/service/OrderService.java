package com.xzsd.app.order.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.RandomUtil;
import com.neusoft.util.StringUtil;
import com.xzsd.app.goodsdetails.dao.GoodsDetailsDao;
import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.personal.dao.PersonalDao;
import com.xzsd.app.personal.entity.LoginMes;
import com.xzsd.app.personal.entity.PersonalInfo;
import com.xzsd.app.shopcart.dao.ShopCartDao;
import com.xzsd.app.shopcart.entity.GoodsMes;
import com.xzsd.app.shopcart.entity.ShopCartInfo;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import util.PasswordUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private GoodsDetailsDao goodsDetailsDao;

    @Resource
    private PersonalDao personalDao;

    @Resource
    private ShopCartDao shopCartDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    //回滚抛出exception
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        if(orderInfo.getGoodsCode() == null || "".equals(orderInfo.getGoodsCode())){
            return AppResponse.bizError("请传入商品编号列表！");
        }
        if(orderInfo.getOrderGoodsCount() == null|| "".equals(orderInfo.getOrderGoodsCount())){
            return AppResponse.bizError("请传入购买商品的数量列表！");
        }
        //设置订单支付状态
        orderInfo.setPayState(1);
        String userCode = SecurityUtils.getCurrentUserId();
        //设置当前登录的角色编号
        orderInfo.setCustCode(userCode);
        //设置当前订单状态
        orderInfo.setOrderState(1);
        //获取当前账户绑定的门店编号
        PersonalInfo personalInfo = new PersonalInfo();
        LoginMes loginMes = personalDao.findLoginMes(userCode);
        //获取登录角色
        personalInfo.setUserRole(loginMes.getUserRole());
        personalInfo.setUserCode(userCode);
        PersonalInfo personalInfo1 = personalDao.findRoleMesByCode(personalInfo);
        //设置门店编号
        orderInfo.setStoreCode(personalInfo1.getStoreCode());
        //设置订单编号
        String newOrderCode = StringUtil.getCommonCode(2);
        orderInfo.setOrderCode(newOrderCode);
        orderInfo.setIsDeleted(0);
        //获取传入的商品编号信息
        List<String> goodsCodeList = Arrays.asList(orderInfo.getGoodsCode().split(","));
        //获取传入的商品数量信息
        List<String> orderGoodsCountList = Arrays.asList(orderInfo.getOrderGoodsCount().split(","));
        //生成空的数组列表储存订单详情列表
        List<OrderMes> orderMesList = new ArrayList<>();
        //这里循环判断新增订单中每个商品的库存是否超标
        for(int j = 0; j < goodsCodeList.size(); j++){
            GoodsMes goodsMes = shopCartDao.findGoodsDe(goodsCodeList.get(j));
            if(goodsMes.getInventory() < Integer.parseInt(orderGoodsCountList.get(j))){
                return AppResponse.bizError(goodsMes.getGoodsName() + "商品库存剩余量为" +goodsMes.getInventory() + "本，库存不足");
            }
        }
        //这里判断订单中的商品是否已下架
        for(int j = 0; j < goodsCodeList.size(); j++){
            GoodsMes goodsMes = shopCartDao.findGoodsDe(goodsCodeList.get(j));
            if(goodsMes.getIsDeleted() == 1){
                return AppResponse.bizError(goodsMes.getGoodsName() + "商品已被下架！");
            }
        }
        //设置总数
        double orderTotalPrice = 0;
        //设置总数
        int totalGoodsCount = 0;
        //根据购物车的商品清单存入订单详情
        for (int i = 0; i < goodsCodeList.size(); i++){
            OrderMes orderMes = new OrderMes();
            String orderDetailsCode = StringUtil.getCommonCode(2);
            orderMes.setOrderDetailsCode(orderDetailsCode);
            orderMes.setGoodsCode(goodsCodeList.get(i));
            orderMes.setGoodsCount(Integer.parseInt(orderGoodsCountList.get(i)));
            //获取当前list商品清单的现价
            GoodsDetailsInfo goodsDetailsInfo = goodsDetailsDao.findGoodsDetailsOJ(goodsCodeList.get(i));
            double nowPrice = Double.valueOf(goodsDetailsInfo.getNowPrice());
            //订单详情中每个商品订单的总价
            orderMes.setOrderTotalPrice(Double.valueOf(orderGoodsCountList.get(i)) * nowPrice);
            orderMes.setOrderCode(newOrderCode);
            orderMes.setIsDeleted(0);
            orderMes.setCreateBy(userCode);
            double totalPrice = Double.valueOf(orderGoodsCountList.get(i)) * nowPrice;
            orderTotalPrice += totalPrice;
            orderMesList.add(orderMes);
        }
        orderInfo.setOrderTotalPrice(orderTotalPrice);
        //新增订单和订单详情
        int count = orderDao.addOrder(orderInfo);
        if(count == 0){
            return AppResponse.bizError("购买失败，添加订单出错！");
        }
        int count2 = orderDao.addOrderMes(orderMesList);
        if(count2 != goodsCodeList.size()){
            return AppResponse.bizError("购买失败，生成订单有误！");
        }
        //移除购物车
        List<String> goodCodeList = Arrays.asList(orderInfo.getGoodsCode().split(","));
        int count3 = shopCartDao.deleteShopCartTwo(goodCodeList,userCode);
        //修改商品库存和销售量
        int count4 = orderDao.updateInventory(orderMesList);
        if(count4 == 0){
            return AppResponse.bizError("修改商品库存失败");
        }
        return AppResponse.success("购买成功");
    }

    /**
     * 查询订单列表
     * @param orderList
     * @Author 张鑫
     * @return
     */
    public AppResponse listOrder(OrderList orderList) {
        List<OrderList>  orderLists = orderDao.listOrder(orderList);
        return AppResponse.success("查询成功",orderLists);
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @Author 张鑫
     * @return
     */
    public AppResponse findOrder(String orderCode) {
        List<OrderSearch>  orderLists = orderDao.findOrder(orderCode);
        return AppResponse.success("查询成功",orderLists);
    }

    /**
     * 订单状态修改
     * @param orderUpdate
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateBossOrderState(OrderUpdate orderUpdate) {
        //订单取消的时候回复库存量和销售量
        if (orderUpdate.getOrderState() == 2){
        List<OrderSearch> orderSearch = orderDao.findOrder(orderUpdate.getOrderCode());
        int count2 = orderDao.updateInventoryTwo(orderSearch.get(0).getGoodsList());
        }
        int count = orderDao.updateOrderState(orderUpdate);
        if (0 == count) {
            return AppResponse.versionError("修改订单状态失败！");
        }
        return AppResponse.success("修改订单状态成功！");
    }

    /**
     * 增加订单商品评价
     * @param orderEva
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrderGoodsEva(OrderEva orderEva){
        //开始处理对象
        if(null == orderEva.getOrderCode()){
            return AppResponse.paramError("订单编号缺失!");
        }
        //为 每件商品评价 生成编号
        orderEva.setUserCode(SecurityUtils.getCurrentUserId());
        for(int i = 0;i < orderEva.getEvaList().size();i++){
            orderEva.getEvaList().get(i).setEvaCode(RandomUtil.randomDriverCode());
            orderEva.getEvaList().get(i).setCustCode(orderEva.getUserCode());
        }
        //当前用户-新增至商品评价列表
        int result = orderDao.addOrderGoodsEva(orderEva.getEvaList(),orderEva.getOrderCode());
        //获取当前订单version
        OrderVersion orderVersion = orderDao.findVersion(orderEva.getOrderCode());
        OrderUpdate orderUpdate = new OrderUpdate();
        orderUpdate.setVersion(orderVersion.getVersion());
        orderUpdate.setOrderCode(orderEva.getOrderCode());
        orderUpdate.setUserCode(SecurityUtils.getCurrentUserId());
        orderUpdate.setOrderState(6);
        int updateOrderState = orderDao.updateOrderState(orderUpdate);
        //更新商品星级
        int updateOrdeerRank = orderDao.updateGoodLevel(orderEva.getEvaList());
        if(updateOrdeerRank == 0){
            return AppResponse.bizError("更新商品星级失败！");
        }
        //结果
        if(result > 0){
            return AppResponse.success("添加商品评论成功!",result);
        }
        return AppResponse.bizError("添加商品评论失败!");
    }

    /**
     * demo 查询商品列表
     * @param orderCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "orderGoodsList")
    public AppResponse orderGoodsList(String orderCode) {
        List<OrderGoodsList> goodsInfoList11 = orderDao.orderGoodsList(orderCode);
        return AppResponse.success("查询成功！", goodsInfoList11);
    }






}
