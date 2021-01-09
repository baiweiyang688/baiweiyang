package com.home.service;


import com.home.dao.HomeDao;
import com.home.entity.HotGoodsAppInfo;
import com.home.entity.RegisterInfo;
import com.home.entity.ViewPageAppInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeService {

    @Resource
    private HomeDao homeDao;

    /**
     * 注册用户
     * @param registerInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    //回滚抛出exception
    @Transactional(rollbackFor = Exception.class)
    //检验账号是否存在
    public AppResponse registerUser(RegisterInfo registerInfo){
        int countUserAcct = homeDao.countUserAcct(registerInfo);
        if(countUserAcct != 0){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        int countUserPhone = homeDao.countUserPhone(registerInfo);
        if (countUserPhone != 0){
            return AppResponse.bizError("用户手机号已存在，请重新输入");
        }
        int countInviteCode = homeDao.countInviteCode(registerInfo);
        if (countInviteCode == 0){
            return AppResponse.bizError("门店邀请码不存在，请重新输入!");
        }
        //密码加密
//        String pwd = PasswordUtils.generatePassword(registerInfo.getUserPassword());
//        registerInfo.setUserPassword(pwd);
        //生成随机编号
        registerInfo.setUserCode(StringUtil.getCommonCode(2));
        registerInfo.setIsDeleted(0);
        //默认顾客
        registerInfo.setUserRole(4);
        //新增用户
        int count = homeDao.registerUser(registerInfo);
        int count2 = homeDao.registerCust(registerInfo);
        if (count == 0 || count2 == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }


    /**
     * demo 查询轮播图
     * @param viewPageAppInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listViewPage")
    public AppResponse listViewPage(ViewPageAppInfo viewPageAppInfo) {
        List<ViewPageAppInfo> viewPageInfoList = homeDao.listViewPage(viewPageAppInfo);
        return AppResponse.success("查询成功！", viewPageInfoList);
    }

    /**
     * demo 查询app端热门商品列表（分页）
     * @param hotGoodsAppInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsAppInfo hotGoodsAppInfo) {
        PageHelper.startPage(hotGoodsAppInfo.getPageNum(), hotGoodsAppInfo.getPageSize());
        List<HotGoodsAppInfo> goodsInfoList = homeDao.listHotGoods(hotGoodsAppInfo);
        PageInfo<HotGoodsAppInfo> pageData = new PageInfo<HotGoodsAppInfo>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }




}
