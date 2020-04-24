package com.goodsdetails.controller;

import com.goodsdetails.entity.GoodsDetailsInfo;
import com.goodsdetails.service.GoodsDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 客户端商品
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class GoodsDetailsController {

    public static final Logger logger =
            LoggerFactory.getLogger(GoodsDetailsController.class);

    @Resource
    private GoodsDetailsService goodsDetailsService;

    /**
     *查询商品详情
     * @param goodsDetailsInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findGoodsDetails")
    public AppResponse findGoodsDetails(GoodsDetailsInfo goodsDetailsInfo) {
        try {
//            String userCode = AuthUtils.getCurrentUserId();
//            goodsDetailsInfo.setUserCode(userCode);
            return goodsDetailsService.findGoodsDetails(goodsDetailsInfo);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }




}
