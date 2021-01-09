package com.xzsd.app.personal.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.personal.entity.PersonalInfo;
import com.xzsd.app.personal.entity.UserImage;
import com.xzsd.app.personal.entity.UserInvite;
import com.xzsd.app.personal.entity.UserPaw;
import com.xzsd.app.personal.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 修改密码
     * @param userPaw
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updatePassword")
    public AppResponse updatePassword(UserPaw userPaw) {
        try {
            return personalService.updatePassword(userPaw);
        } catch (Exception e) {
            logger.error("修改错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改店铺邀请码
     * @param userInvite
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updateInviteCode")
    public AppResponse updateInviteCode(UserInvite userInvite) {
        try {
            return personalService.updateInviteCode(userInvite);
        } catch (Exception e) {
            logger.error("修改错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改用户头像
     * @param userImage
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updateUserImage")
    public AppResponse updateUserImage(UserImage userImage) {
        try {
            return personalService.updateUserImage(userImage);
        } catch (Exception e) {
            logger.error("修改错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *查询角色个人信息
     * @param userAcct
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findLoginRole")
    public AppResponse findLoginRole(String userAcct) {
        try {
            return personalService.findRoleByAcct(userAcct);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }



}
