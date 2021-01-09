package com.order.controller;

import com.goods.controller.GoodsController;
import com.goods.entity.GoodsInfo;
import com.goods.service.GoodsService;
import com.order.entity.OrderList;
import com.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;

import javax.annotation.Resource;

/**
 * @Description 商品增删改查
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final Logger logger =
            LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param orderList
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderList orderList) {
        try {
            return orderService.listOrder(orderList);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询订单详情
     * @param orderCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-4-17
     */
    @RequestMapping(value = "findOrder")
    public AppResponse findOrder(String orderCode) {
        try {
            return orderService.findOrder(orderCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单
     * @param orderState
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode, String orderState){
        try {
            //获取修改者id
            String userCode = "51654644";
            return orderService.updateOrderState(orderCode,userCode,orderState);
        }catch (Exception e){
            logger.error("修改轮播图状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
