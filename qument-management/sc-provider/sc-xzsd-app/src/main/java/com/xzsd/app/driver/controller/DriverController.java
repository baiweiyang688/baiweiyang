package com.xzsd.app.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.goodsdetails.controller.GoodsDetailsController;
import com.xzsd.app.goodsdetails.service.GoodsDetailsService;
import com.xzsd.app.home.entity.HotGoodsAppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 司机个人信息
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class DriverController {

    public static final Logger logger =
            LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * 查询司机负责的门店信息
     * @param driverInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findDriver")
    public AppResponse findDriver(DriverInfo driverInfo) {
        try {
            return driverService.findDriver(driverInfo);
        } catch (Exception e) {
            logger.error("查询负责的门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }



}
