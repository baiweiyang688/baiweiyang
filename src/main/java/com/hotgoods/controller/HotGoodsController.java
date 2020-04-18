package com.hotgoods.controller;

import com.goods.controller.GoodsController;
import com.goods.entity.GoodsInfo;
import com.goodscate.service.GoodsCateService;
import com.hotgoods.entity.HotGoodsInfo;
import com.hotgoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 热门商品
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {

    public static final Logger logger =
            LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;


    /**
     * 新增商品
     * @param hotGoodsInfo
     * @Author 张鑫
     * @Date 2020-4-18
     */
    @PostMapping("addHotGoods")
    public AppResponse addGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfo.setCreateBy(userId);
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
