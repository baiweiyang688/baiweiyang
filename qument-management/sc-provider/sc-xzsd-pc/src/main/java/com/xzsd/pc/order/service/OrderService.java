package com.xzsd.pc.order.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderList;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.LoginInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;

    /**
     * demo 查询订单列表（分页）
     * @param orderList
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderList orderList) {
        //通过findlogin获取当前登录人的角色role
        String userCode = SecurityUtils.getCurrentUserId();
        LoginInfo userInfoOrder = userDao.findLogin(userCode);
        //设置角色
        orderList.setUserRole(userInfoOrder.getUserRole());
        //设置当前角色编号
        orderList.setUserCode(userInfoOrder.getLoginCode());
        PageHelper.startPage(orderList.getPageNum(), orderList.getPageSize());
        List<OrderList> orderLists = orderDao.listOrder(orderList);
        PageInfo<OrderList> pageData = new PageInfo<OrderList>(orderLists);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 查询订单详情
     * @param orderInfo
     * @return
     * @Author 张鑫
     * @Date 2020-4-17
     */
    public AppResponse findOrder(OrderInfo orderInfo) {
        if (orderInfo.getOrderCode() == null || "".equals(orderInfo.getOrderCode())){
            return AppResponse.bizError("请输入订单编号");
        }
        List<OrderInfo> orderInfos = orderDao.findOrder(orderInfo);
//        OrderInfo goodsInfo = orderDao.findOrder(orderCode);
        return AppResponse.success("查询成功！", orderInfos);
    }

    /**
     * 修改订单状态
     * @param orderState
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String orderCode,String userId,String orderState) {
        List<String> listCode = Arrays.asList(orderCode.split(","));
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = orderDao.updateOrderState(listCode,userId,orderState);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }






}
