package com.xzsd.app.personal.dao;


import com.xzsd.app.personal.entity.LoginMes;
import com.xzsd.app.personal.entity.PersonalInfo;
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



}
