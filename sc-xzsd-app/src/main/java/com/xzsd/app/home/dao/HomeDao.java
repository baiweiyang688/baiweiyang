package com.xzsd.app.home.dao;


import com.xzsd.app.home.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeDao {
    /**
     * 统计邀请码是否为店家邀请码
     * @param registerInfo
     * @return
     */
    int countInviteCode(RegisterInfo registerInfo);

    /**
     * 统计用户注册数量
     * @param registerInfo
     * @return
     */
    int countUserAcct(RegisterInfo registerInfo);

    /**
     * 统计用户手机号数量
     * @param registerInfo
     * @return
     */
    int countUserPhone(RegisterInfo registerInfo);

    /**
     * 用户注册用户表
     * @param registerInfo
     * @return
     */
    int registerUser(RegisterInfo registerInfo);

    /**
     * 用户注册用户表
     * @param registerInfo
     * @return
     */
    int registerCust(RegisterInfo registerInfo);

    /**
     * 获取app端所有轮播图信息
     * @param viewPageAppInfo
     * @return 所有用户信息
     */
    List<ViewPageAppInfo> listViewPage(ViewPageAppInfo viewPageAppInfo);

    /**
     * 获取app端所有热门商品信息
     * @param hotGoodsAppInfo
     * @return 所有用户信息
     */
    List<HotGoodsAppInfo> listHotGoods(HotGoodsAppInfo hotGoodsAppInfo);

    /**
     * 获取app端一级分类信息
     * @param oneLevel
     * @return 所有用户信息
     */
    List<OneLevel> oneLevel(OneLevel oneLevel);

    /**
     * 查询商品二级分类
     * @param twoLevel
     * @return
     */
    List<TwoLevel> twoLevel(@Param("twoLevel") TwoLevel twoLevel,@Param("cateParentCode") String cateParentCode);

}
