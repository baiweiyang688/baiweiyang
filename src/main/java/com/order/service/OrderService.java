package com.order.service;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.GoodsDao;
import com.goods.entity.GoodsInfo;
import com.order.dao.OrderDao;
import com.order.entity.OrderInfo;
import com.order.entity.OrderList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * demo 查询订单列表（分页）
     * @param orderList
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderList orderList) {
        PageHelper.startPage(orderList.getPageNum(), orderList.getPageSize());
        List<OrderList> orderLists = orderDao.listOrder(orderList);
        PageInfo<OrderList> pageData = new PageInfo<OrderList>(orderLists);
        return AppResponse.success("查询成功！", pageData);

    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     * @Author 张鑫
     * @Date 2020-4-17
     */
    public AppResponse findOrder(String orderCode) {
        if (orderCode == null ){
            return AppResponse.bizError("请输入订单编号");
        }
        OrderInfo goodsInfo = orderDao.findOrder(orderCode);
        return AppResponse.success("查询成功！", goodsInfo);
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
