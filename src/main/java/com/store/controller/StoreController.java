package com.store.controller;


import com.store.entity.StoreInfo;
import com.store.service.StoreService;
import com.viewpage.controller.ViewPageController;
import com.viewpage.entity.ViewPageInfo;
import com.viewpage.service.ViewPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 门店
 * @Author 张鑫
 * @Date 2020-4-13
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    public static final Logger logger =
            LoggerFactory.getLogger(ViewPageController.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @param storeInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */

    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            //boss
            storeInfo.setCreateBy(userId);
            storeInfo.setBossCode(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
