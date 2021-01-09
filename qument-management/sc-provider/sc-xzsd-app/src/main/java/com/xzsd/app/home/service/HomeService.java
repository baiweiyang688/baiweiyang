package com.xzsd.app.home.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.app.home.dao.HomeDao;
import com.xzsd.app.home.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.PasswordUtils;


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
    public AppResponse registerUser(RegisterInfo registerInfo){
        registerInfo.setIsDeleted(0);
        int countUserAcct = homeDao.countUserAcct(registerInfo);
        if(countUserAcct != 0){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        int countUserPhone = homeDao.countUserPhone(registerInfo);
        if (countUserPhone != 0){
            return AppResponse.bizError("用户手机号已存在，请重新输入");
        }
        if(!"".equals(registerInfo.getInviteCode())){
            int countInviteCode = homeDao.countInviteCode(registerInfo);
            if (countInviteCode == 0){
                return AppResponse.bizError("门店邀请码不存在，请重新输入!");
            }
        }
        if(registerInfo.getUserSex() == 0 || "".equals(registerInfo.getUserSex())){
            registerInfo.setUserSex(1);
        }
        String pwd = PasswordUtils.generatePassword(registerInfo.getUserPassword());
        registerInfo.setUserPassword(pwd);
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
     * demo 查询app端热门商品列表
     * @param hotGoodsAppInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsAppInfo hotGoodsAppInfo) {
        HotGoodsShow hotGoodsShow = new HotGoodsShow();
        HotGoodsShow hotGoodsShow2 = homeDao.findShowNumber(hotGoodsShow);
        hotGoodsAppInfo.setShowNumber(hotGoodsShow2.getShowNumber());
        System.out.println(hotGoodsShow2.getShowNumber());
        List<HotGoodsAppInfo> goodsInfoList = homeDao.listHotGoods(hotGoodsAppInfo);
        return AppResponse.success("查询成功！", goodsInfoList);
    }

    /**
     * demo 查询一级分类详情
     * @param oneLevel
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "oneLevel")
    public AppResponse oneLevel(OneLevel oneLevel) {
        List<OneLevel> oneLevels = homeDao.oneLevel(oneLevel);
        return AppResponse.success("查询成功！", oneLevels);
    }

    /**
     * demo 查询二级分类详情
     * @param
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "twoLevel")
    public AppResponse twoLevelList(TwoLevel twoLevel,String cateParentCode) {
        if(cateParentCode == null || "".equals(cateParentCode)){
            return AppResponse.bizError("请传入父类分类编号获取分类商品详情！");
        }
        List<TwoLevel> twoLevels = homeDao.twoLevel(twoLevel,cateParentCode);
        return AppResponse.success("查询成功！", twoLevels);
    }






}
