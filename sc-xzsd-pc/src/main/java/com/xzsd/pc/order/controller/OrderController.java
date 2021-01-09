package com.xzsd.pc.order.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderList;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @Description 订单增删改查
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final Logger logger =
            LoggerFactory.getLogger(OrderController.class);

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
     * @param orderInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-4-17
     */
    @RequestMapping(value = "findOrder")
    public AppResponse findOrder(OrderInfo orderInfo) {
        try {
            return orderService.findOrder(orderInfo);
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
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode, String orderState){
        try {
            //获取修改者id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderCode,userCode,orderState);
        }catch (Exception e){
            logger.error("修改轮播图状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
