package com.xzsd.pc.customer.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.goods.controller.GoodsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
            LoggerFactory.getLogger(CustomerController.class);

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
