package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverList;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
            String userId = SecurityUtils.getCurrentUserId();
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

    /**
     * 修改司机信息
     * @param driverInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try {
            //获取修改者id
            String userCode = SecurityUtils.getCurrentUserId();
            driverInfo.setLastModifiedBy(userCode);
            return driverService.updateDriver(driverInfo);
        }catch (Exception e){
            logger.error("修改商品信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机列表
     * @param driverList
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverList driverList) {
        try {
            return driverService.listDriver(driverList);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机信息
     * @param driverCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverCode){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
