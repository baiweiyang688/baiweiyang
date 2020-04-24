package com.personal.dao;

import com.personal.entity.LoginMes;
import org.apache.ibatis.annotations.Param;

public interface PersonalDao {

    /**
     * 查询用户登录信息角色
     * @param userCode 用户编号
     * @return 修改结果
     */
    LoginMes findLoginMes(@Param("userCode") String userCode);




}
