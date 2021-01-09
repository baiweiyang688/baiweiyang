package com.xzsd.pc.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.LoginInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 用户实现功能类
 * @Author 张鑫
 * @Date 2020-03-25
 */
@Service
public class UserService {

    @Resource
    private UserDao demoDao;

    /**
     * 新增用户
     */
    //回滚抛出exception
    @Transactional(rollbackFor = Exception.class)
    //检验账号是否存在
    public AppResponse saveUser(UserInfo userInfo){
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if(countUserAcct != 0){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //生成随机编号
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);

        String pwd = PasswordUtils.generatePassword("123456");
        userInfo.setUserPassword(pwd);
        //新增用户
        int count = demoDao.saveUser(userInfo);
        if (count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");

    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author baiweiyang
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = demoDao.listUsers(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询用户详情
     * @param userCode
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    public AppResponse findUser(String userCode) {
        UserInfo userInfo = demoDao.findUser(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {

        //修改的时候再次加密用户密码
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));

        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = demoDao.updateUser(userInfo);
        //数据库判断条件是code和version version变换了 则count为0 然后需要
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除用户
     * @param userCode
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = demoDao.deleteUser(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
    }
        return appResponse;
    }

    /**
     * 查询登录用户详情
     * @param userCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findLogin(String userCode) {
        LoginInfo loginInfo = demoDao.findLogin(userCode);
        return AppResponse.success("查询成功！",loginInfo);
    }


}
