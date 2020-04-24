package com.xzsd.app.personal.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.personal.entity.PersonalInfo;
import com.xzsd.app.personal.service.PersonalService;
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

    /**
     *查询角色个人信息
     * @param personalInfo
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findRoleMes")
    public AppResponse findUser(PersonalInfo personalInfo) {
        try {
            return personalService.findRoleMes(personalInfo);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }






}
