package com.xzsd.app.orderdetails.controller;

import com.xzsd.app.orderdetails.service.OrderDetailsService;
import com.xzsd.app.personal.controller.PersonalController;
import com.xzsd.app.personal.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class OrderDetailsController {

    public static final Logger logger =
            LoggerFactory.getLogger(OrderDetailsController.class);

    @Resource
    private OrderDetailsService orderDetailsService;





}
