package com.home.controller;


import com.home.entity.HotGoodsAppInfo;
import com.home.entity.RegisterInfo;
import com.home.entity.ViewPageAppInfo;
import com.home.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 客户端主页
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class HomeController {
    public static final Logger logger =
            LoggerFactory.getLogger(HomeController.class);

    @Resource
    private HomeService homeService;

    /**
     * 注册用户
     * @param registerInfo
     * @Author baiweiyang
     * @Date 2020-4-21
     */
    @PostMapping("registerUser")
    public AppResponse registerUser(RegisterInfo registerInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            registerInfo.setCreateBy(userId);
            AppResponse appResponse = homeService.registerUser(registerInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表
     * @param viewPageAppInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listViewPage")
    public AppResponse listViewPage(ViewPageAppInfo viewPageAppInfo) {
        try {
            return homeService.listViewPage(viewPageAppInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询app端热门商品列表
     * @param hotGoodsAppInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsAppInfo hotGoodsAppInfo) {
        try {
            return homeService.listHotGoods(hotGoodsAppInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }





}
