package com.driver.controller;

import com.driver.entity.DriverInfo;
import com.driver.service.DriverService;
import com.goods.controller.GoodsController;
import com.goods.entity.GoodsInfo;
import com.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;
/**
 * @Description 司机增删改查
 * @Author 张鑫
 * @Date 2020-4-19
 */
//映射注释
@RestController
@RequestMapping("/driver")
public class DriverController {

    public static final Logger logger =
            LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * 新增司机到用户表和司机表
     * @param driverInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询司机详情
     * @param driverCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findDriver")
    public AppResponse findDriver(String driverCode) {
        try {
            return driverService.findDriver(driverCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
