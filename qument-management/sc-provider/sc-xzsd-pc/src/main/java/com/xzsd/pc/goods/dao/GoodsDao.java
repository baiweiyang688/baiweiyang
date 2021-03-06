package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodsCate;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.MqInfo;
import com.xzsd.pc.goods.entity.StoreIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张鑫
 */
public interface GoodsDao {
    /**
     * 统计商品名称
     * @param goodsInfo 商品信息
     * @return
     */
    int countGoodsName(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品信息
     * @param goodsCode 用户编号
     * @return 修改结果
     */
    GoodsInfo findGoods(@Param("goodsCode") String goodsCode);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return
     */
    List<GoodsInfo> listGoods(GoodsInfo goodsInfo);

    /**
     * 储存新增商品信息
     * @param mqInfo
     * @return
     */
    int addMessage(MqInfo mqInfo);

    /**
     * 修改商品信息
     * @param goodsInfo
     * @return
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 删除商品信息
     * @param listCode 商品信息集合
     * @param userId
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 获取商品一级分类
     * @param goodsCate
     * @return
     */
    List<GoodsCate> oneLevel(GoodsCate goodsCate);

    /**
     * 获取商品二级分类
     * @param goodsCate
     * @return
     */
    List<GoodsCate> twoLevel(GoodsCate goodsCate);

    /**
     * 获取店家编码、名称
     * @param storeIn
     * @return
     */
    List<StoreIn> storeMes(StoreIn storeIn);

    /**
     * 修改商品状态
     * @param goodsState
     * @param userId
     * @return 修改结果
     */
    int updateGoodsState(@Param("listCode") List<String> listCode, @Param("userId") String userId, @Param("goodsState") String goodsState);





}
