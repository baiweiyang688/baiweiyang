package com.xzsd.app.personal.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.personal.dao.PersonalDao;
import com.xzsd.app.personal.entity.LoginMes;
import com.xzsd.app.personal.entity.PersonalInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonalService {

    @Resource
    private PersonalDao personalDao;


    /**
     * 查询不同的角色的个人信息
     * @param personalInfo
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    public AppResponse findRoleMes(PersonalInfo personalInfo) {
        String userCode = SecurityUtils.getCurrentUserId();
        LoginMes loginMes = personalDao.findLoginMes(userCode);
        //获取登录角色
        personalInfo.setUserRole(loginMes.getUserRole());
        //获取登录角色编号
        personalInfo.setUserCode(loginMes.getLoginCode());
        List<PersonalInfo> personalInfos = personalDao.findRoleMes(personalInfo);
        return AppResponse.success("查询成功！",personalInfos);
    }




}
