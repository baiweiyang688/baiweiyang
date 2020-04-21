package com.client.controller;


import com.client.entity.HotGoodsAppInfo;
import com.client.entity.RegisterInfo;
import com.client.entity.ViewPageAppInfo;
import com.client.service.ClientService;
import com.customer.service.CustomerService;
import com.goods.controller.GoodsController;
import com.hotgoods.entity.HotGoodsList;
import com.user.entity.UserInfo;
import com.viewpage.entity.ViewPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 客户端
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class ClientController {
    public static final Logger logger =
            LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ClientService clientService;

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
            AppResponse appResponse = clientService.registerUser(registerInfo);
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
            return clientService.listViewPage(viewPageAppInfo);
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
            return clientService.listHotGoods(hotGoodsAppInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }





}
