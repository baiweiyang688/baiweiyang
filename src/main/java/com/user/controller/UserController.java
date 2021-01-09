package com.user.controller;



import com.user.entity.UserInfo;
import com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 增删改查DEMO
 * @Author 张鑫
 * @Date 2020-3-25
 */

//映射注释
@RestController
@RequestMapping("/demo")
public class UserController {
    public static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService demoService;

    /**
     * 新增用户
     * @param userInfo
     * @Author baiweiyang
     * @Date 2020-3-25
     */

    @PostMapping("saveUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = demoService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 用户列表
     * @param userInfo
     * @return AppResponse
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return demoService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
        /**
         *查询用户详情
         * @param userCode
         * @return AppResponse
         * @author baiweiyang
         * @Date 2020-3-26
         */
        @RequestMapping(value = "findUser")
        public AppResponse findUser(String userCode) {
            try {
                return demoService.findUser(userCode);
            } catch (Exception e) {
                logger.error("用户查询错误", e);
                System.out.println(e.toString());
                throw e;
            }
        }

    /**
     *修改用户
     * @param userInfo
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            userInfo.setLastModifiedBy(userId);
            return demoService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *删除用户
     * @param userCode
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return demoService.deleteUser(userCode,userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
