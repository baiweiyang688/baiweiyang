package com.xzsd.app.shopcart.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.RandomUtil;
import com.neusoft.util.StringUtil;
import com.xzsd.app.goodsdetails.dao.GoodsDetailsDao;
import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import com.xzsd.app.home.dao.HomeDao;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.home.entity.ViewPageAppInfo;
import com.xzsd.app.personal.dao.PersonalDao;
import com.xzsd.app.personal.entity.LoginMes;
import com.xzsd.app.personal.entity.PersonalInfo;
import com.xzsd.app.shopcart.dao.ShopCartDao;
import com.xzsd.app.shopcart.entity.GoodsMes;
import com.xzsd.app.shopcart.entity.ShopCartInfo;
import com.xzsd.app.shopcart.entity.ShopCartList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.PasswordUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ShopCartService {

    @Resource
    private ShopCartDao shopCartDao;

    @Resource
    private GoodsDetailsDao goodsDetailsDao;



    /**
     * 添加商品到购物车
     * @param shopCartInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    //回滚抛出exception
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShopCart(ShopCartInfo shopCartInfo){
        shopCartInfo.setIsDeleted(0);
        if (shopCartInfo.getGoodsCode() == null || "".equals(shopCartInfo.getGoodsCode())){
            return AppResponse.bizError("请传入商品编号");
        }
        if(shopCartInfo.getGoodsCount() == 0 || "".equals(shopCartInfo.getGoodsCount())){
            return AppResponse.bizError("请传入购买商品数量");
        }
        //获取登录者编号
        String loginCode = SecurityUtils.getCurrentUserId();
        shopCartInfo.setCustCode(loginCode);
        //设置购物车编号
        String shopCartCode = StringUtil.getCommonCode(2);
        shopCartInfo.setShopCartCode(shopCartCode);
        //获取当前的商品信息
        GoodsMes goods = shopCartDao.findGoodsDe(shopCartInfo.getGoodsCode());
        //获取总价
        float a = (float)shopCartInfo.getGoodsCount();
        float b= Float.parseFloat(goods.getNowPrice());
        shopCartInfo.setTotalPrice(a * b);
        int count = shopCartDao.addShopCart(shopCartInfo);
        if (count == 0 ){
            return AppResponse.bizError("添加到购物车失败，请重试！");
        }
        return AppResponse.success("添加到购物车成功");
    }


    /**
     * 查询购物车列表详情
     * @param shopCartList
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listShopCart")
    public AppResponse listShopCart(ShopCartList shopCartList) {
        List<ShopCartList> shopCartLists = shopCartDao.listShopCart(shopCartList);
        return AppResponse.success("查询成功！", shopCartLists);
    }

    /**
     * 删除购物车清单商品
     * @param shopCartCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShopCart(String shopCartCode, String userId) {
        List<String> listCode = Arrays.asList(shopCartCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = shopCartDao.deleteShopCart(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改购物车清单商品数量
     * @param shopCartInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShopCart(ShopCartInfo shopCartInfo) {
        if(shopCartInfo.getGoodsCode() == null || "".equals(shopCartInfo.getGoodsCode())){
            return AppResponse.bizError("请传入修改的商品编号！");
        }
        if(shopCartInfo.getGoodsCount() == 0 || "".equals(shopCartInfo.getGoodsCount())){
            return AppResponse.bizError("请传入修改的商品数量！");
        }
        if(shopCartInfo.getShopCartCode() == null || "".equals(shopCartInfo.getShopCartCode())){
            return AppResponse.bizError("请传入待修改的购物车编号！");
        }
        //传入修改的总价
        GoodsMes goods = shopCartDao.findGoodsDe(shopCartInfo.getGoodsCode());
        float a = (float)shopCartInfo.getGoodsCount();
        float b= Float.parseFloat(goods.getNowPrice());
        shopCartInfo.setTotalPrice(a * b);
        AppResponse appResponse = AppResponse.success("修改成功！");
        int count = shopCartDao.updateShopCart(shopCartInfo);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }




}
