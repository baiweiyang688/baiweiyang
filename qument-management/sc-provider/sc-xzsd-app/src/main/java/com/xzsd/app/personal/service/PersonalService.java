package com.xzsd.app.personal.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.home.dao.HomeDao;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.personal.dao.PersonalDao;
import com.xzsd.app.personal.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PasswordUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonalService {

    @Resource
    private PersonalDao personalDao;

    @Resource
    private HomeDao homeDao;

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

    /**
     * 修改密码
     * @param userPaw
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePassword(UserPaw userPaw) {
        //获取当前用户编号
        String loginCode = SecurityUtils.getCurrentUserId();
        userPaw.setUserCode(loginCode);
        if (null != userPaw.getOldPassword() && !"".equals(userPaw.getNewPassword())) {
            UserPaw userPaw1 = personalDao.findPassword(loginCode);
            boolean password = PasswordUtils.Password(userPaw.getOldPassword(), userPaw1.getUserPassword());
            if (!password) {
                return AppResponse.bizError("原密码不对，请重新输入！");
            }
        }
        userPaw.setNewPassword(PasswordUtils.generatePassword(userPaw.getNewPassword()));
        int count = personalDao.updatePassword(userPaw);
        if (0 == count) {
            return AppResponse.versionError("修改密码失败！");
        }
        return AppResponse.success("修改密码成功！");
    }


    /**
     * 修改店铺邀请码
     * @param userInvite
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInviteCode(UserInvite userInvite) {
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setInviteCode(userInvite.getNewInviteCode());
        String loginCode = SecurityUtils.getCurrentUserId();
        userInvite.setUserCode(loginCode);
        //校验新的邀请码
        int countInviteCode = homeDao.countInviteCode(registerInfo);
        if (0 == countInviteCode) {
            return AppResponse.bizError("修改店铺邀请码不存在，请重新输入！");
        }
        int count = personalDao.updateInviteCode(userInvite);
        if (0 == count) {
            return AppResponse.bizError("修改失败请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 修改用户头像
     * @param userImage
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserImage(UserImage userImage) {
        if (userImage.getUserImage() == null || "".equals(userImage.getUserImage())){
            return AppResponse.bizError("新的用户头像地址为空，请重新传入！");
        }
        String loginCode = SecurityUtils.getCurrentUserId();
        userImage.setUserCode(loginCode);
        int count = personalDao.updateUserImage(userImage);
        if (0 == count) {
            return AppResponse.bizError("修改失败请重试！");
        }
        return AppResponse.success("修改成功！");
    }


    /**
     * 根据角色账号查询角色
     * @param userAcct
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    public AppResponse findRoleByAcct(String userAcct) {
         List<LoginInfo> loginInfo = personalDao.findLoginRole(userAcct);
        return AppResponse.success("查询成功！",loginInfo);
    }


}
