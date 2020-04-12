package com.customer.controller;

import com.customer.entity.CustomerInfo;
import com.customer.service.CustomerService;
import com.goods.controller.GoodsController;
import com.goods.entity.GoodsInfo;
import com.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;

import javax.annotation.Resource;

/**
 * @Description 顾客表列表查询
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/customer")
public class CustomerController {
    public static final Logger logger =
            LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private CustomerService customerService;
    /**
     * 查询客户列表
     * @param customerInfo
     * @return AppResponse
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        try {
            return customerService.listCustomer(customerInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
