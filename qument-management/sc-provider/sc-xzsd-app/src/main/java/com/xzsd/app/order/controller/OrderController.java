package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description App订单
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class OrderController {

    public static final Logger logger =
            LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * @param orderInfo
     * @Author baiweiyang
     * @Date 2020-4-21
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateBy(userId);
            AppResponse appResponse = orderService.addOrder(orderInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表
     * @param orderList
     * @Author 张鑫
     * @return
     */
    @RequestMapping("listOrder")
    public AppResponse findOrder(OrderList orderList){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderList.setUserCode(userCode);
            AppResponse appResponse = orderService.listOrder(orderList);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询
     * @param orderCode
     * @Author 张鑫
     * @return
     */
    @RequestMapping("findOrder")
    public AppResponse listOrder(String orderCode){
        try{
            AppResponse appResponse = orderService.findOrder(orderCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单状态修改，确认收货、取消订单
     * @param orderUpdate
     * @Author 张鑫
     * @return
     */
    @PostMapping("updateOrderState")
    public AppResponse updateBossOrderState(OrderUpdate orderUpdate) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderUpdate.setUserCode(userId);
            return orderService.updateBossOrderState(orderUpdate);
        } catch (Exception e) {
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增订单商品评价
     * @param orderEva
     * @return
     */
    @PostMapping(value = "addOrderGoodsEva",headers = {"content-type=application/json"})
    public AppResponse addOrderGoodsEva(@RequestBody OrderEva orderEva){
        try{
            return orderService.addOrderGoodsEva(orderEva);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param orderCode
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "goodsList")
    public AppResponse orderGoodsList(String orderCode) {
        try {
            return orderService.orderGoodsList(orderCode);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
