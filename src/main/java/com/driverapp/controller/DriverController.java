package com.driverapp.controller;

import com.driverapp.service.DriverService;
import com.user.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;

import javax.annotation.Resource;

/**
 * @Description app端的
 * @Author 张鑫
 * @Date 2020-3-25
 */

@RestController
@RequestMapping("/driver")
public class DriverController {
    public static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Resource
    private DriverService driverService;

    /**
     *查询用户详情
     * @param userCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findDriver")
    public AppResponse findDriver(String userCode) {
        try {
            return driverService.findDriver(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }







}
