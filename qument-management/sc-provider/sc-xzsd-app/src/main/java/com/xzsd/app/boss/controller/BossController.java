package com.xzsd.app.boss.controller;

import com.mysql.jdbc.StringUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.boss.entity.BossOrder;
import com.xzsd.app.boss.entity.BossUpdate;
import com.xzsd.app.boss.entity.DriverMes;
import com.xzsd.app.boss.service.BossService;
import com.xzsd.app.driver.controller.DriverController;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.order.entity.OrderList;
import com.xzsd.app.order.entity.OrderUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 店长
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class BossController {

    public static final Logger logger =
            LoggerFactory.getLogger(BossController.class);

    @Resource
    private BossService bossService;

    /**
     * 查询店长下的司机信息
     * @param driverMes
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findDriverMes")
    public AppResponse findDriverMes(DriverMes driverMes) {
        try {
            driverMes.setUserCode(SecurityUtils.getCurrentUserId());
            return bossService.findDriverMes(driverMes);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询店长订单列表
     * @param bossOrder
     * @Author 张鑫
     * @return
     */
    @RequestMapping("listBossOrder")
    public AppResponse listBossOrder(BossOrder bossOrder){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            bossOrder.setUserCode(userCode);
            AppResponse appResponse = bossService.listBossOrder(bossOrder);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询店长订单详情
     * @param orderCode
     * @Author 张鑫
     * @return
     */
    @RequestMapping("findBossOrder")
    public AppResponse findBossOrder(String orderCode){
        try{
            AppResponse appResponse = bossService.findBossOrder(orderCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单状态修改，确认收货、取消订单
     * @param bossUpdate
     * @Author 张鑫
     * @return
     */
    @PostMapping("updateBossOrderState")
    public AppResponse updateOrderState(BossUpdate bossUpdate) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            bossUpdate.setUserCode(userId);
            return bossService.updateBossOrderState(bossUpdate);
        } catch (Exception e) {
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
