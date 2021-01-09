package com.xzsd.app.personal.dao;


import com.xzsd.app.personal.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonalDao {

    /**
     * 查询用户登录信息角色
     * @param userCode 用户编号
     * @return 修改结果
     */
    LoginMes findLoginMes(@Param("userCode") String userCode);

    /**
     * 查询各个角色个人信息
     * @param personalInfo
     * @return 修改结果
     */
    List<PersonalInfo> findRoleMes(PersonalInfo personalInfo);


    /**
     * 查询各个角色的编号查询个人信息
     * @param personalInfo
     * @return 修改结果
     */
    PersonalInfo findRoleMesByCode(PersonalInfo personalInfo);

    /**
     * 获取用户原密码密文
     * @param userCode
     * @return
     */
    UserPaw findPassword(String userCode);

    /**
     * 修改密码
     * @param userPaw
     * @return
     */
    int updatePassword(UserPaw userPaw);

    /**
     * 修改店铺邀请码
     * @param userInvite
     * @return
     */
    int updateInviteCode(UserInvite userInvite);

    /**
     * 修改用户头像
     * @param userImage
     * @return
     */
    int updateUserImage(UserImage userImage);

    /**
     * 根据角色账号查询角色
     * @param userAcct
     * @return 修改结果
     */
    List<LoginInfo> findLoginRole(@Param("userAcct") String userAcct);


}
