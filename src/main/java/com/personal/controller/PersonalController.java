package com.personal.controller;

import com.goodsdetails.controller.GoodsDetailsController;
import com.goodsdetails.service.GoodsDetailsService;
import com.personal.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 个人信息
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class PersonalController {

    public static final Logger logger =
            LoggerFactory.getLogger(PersonalController.class);

    @Resource
    private PersonalService personalService;






}
