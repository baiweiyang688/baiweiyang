package com.xzsd.app.goodsdetails.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goodsdetails.entity.EvaContentInfo;
import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import com.xzsd.app.goodsdetails.service.GoodsDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param goodsCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findGoodsDetails")
    public AppResponse findGoodsDetails(String goodsCode) {
        try {
//            String userCode = AuthUtils.getCurrentUserId();
//            goodsDetailsInfo.setUserCode(userCode);
            return goodsDetailsService.findGoodsDetails(goodsCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品评价详情
     * @param evaContentInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listEvaContent")
    public AppResponse listEvaContent(EvaContentInfo evaContentInfo) {
        try {
//            String userCode = AuthUtils.getCurrentUserId();
//            goodsDetailsInfo.setUserCode(userCode);
            return goodsDetailsService.listEvaContent(evaContentInfo);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }





}
