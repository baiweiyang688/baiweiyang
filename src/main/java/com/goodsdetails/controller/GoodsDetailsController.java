package com.goodsdetails.controller;

import com.goodsdetails.service.GoodsDetailsService;
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



}
