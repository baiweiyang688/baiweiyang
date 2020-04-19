package com.viewpage.dao;

import com.goods.entity.GoodsInfo;
import com.hotgoods.entity.HotGoodsInfo;
import com.viewpage.entity.GoodsViewPageInfo;
import com.viewpage.entity.ViewPageInfo;
import com.viewpage.entity.ViewPageMes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张鑫
 */
public interface ViewPageDao {
    /**
     * 新增轮播图
     * @param viewPageInfo
     * @return
     */
    int addViewPage(ViewPageInfo viewPageInfo);

    /**
     * 修改轮播图状态
     * @param userId
     * @param viewPageState
     * @return
     */
    int updateViewPageState(@Param("listCode") List<String> listCode,@Param("userId") String userId,@Param("viewPageState") String viewPageState);

    /**
     * 获取轮播图状态
     * @param viewPageInfo
     * @return
     */
     List<ViewPageInfo> getViewPageState(ViewPageInfo viewPageInfo);

    /**
     * 获取所有轮播图信息
     * @param viewPageInfo
     * @return 所有用户信息
     */
    List<ViewPageInfo> listViewPage(ViewPageInfo viewPageInfo);

    /**
     * 删除轮播图信息
     * @param listViewPage 商品信息集合
     * @param userId
     * @return
     */
    int deleteViewPage(List<String> listViewPage,@Param("userId") String userId);

    /**
     * 获取所有商品信息
     * @param goodsViewPageInfo 商品信息
     * @return 所有用户信息
     */
    List<GoodsViewPageInfo> listGoods(GoodsViewPageInfo goodsViewPageInfo);

    /**
     * 查询商品信息
     * @param goodsCode 用户编号
     * @param goodsName
     * @return 修改结果
     */
    GoodsViewPageInfo findGoods(@Param("goodsName") String goodsName,@Param("goodsCode") String goodsCode);

    /**
     * 查询轮播图信息详情
     * @param viewPageCode
     * @return 修改结果
     */
    ViewPageMes findViewPage(@Param("viewPageCode") String viewPageCode);

    /**
     * 统计轮播图序号
     * @param viewPageInfo
     * @return
     */
    int countViewPageNum(ViewPageInfo viewPageInfo);


}
