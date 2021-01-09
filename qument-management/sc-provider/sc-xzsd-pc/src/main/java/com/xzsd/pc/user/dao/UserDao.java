package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.LoginInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DemoDao
 * @Description Demo
 * @Author baiweiyang
 * @Date 2020-03-25
 */
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsers(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    UserInfo findUser(@Param("userCode") String userCode);


    /**
     * 查询用户登录信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    LoginInfo findLogin(@Param("userCode") String userCode);


}
