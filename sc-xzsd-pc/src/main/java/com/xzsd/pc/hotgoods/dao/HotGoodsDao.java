package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsList;
import com.xzsd.pc.hotgoods.entity.HotGoodsMes;
import com.xzsd.pc.hotgoods.entity.HotGoodsShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotGoodsDao {

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 统计商品热门排序序号
     * @param hotGoodsInfo
     * @return
     */
    int countHotSort(HotGoodsInfo hotGoodsInfo);

    /**
     * 统计商品编号
     * @param hotGoodsInfo
     * @return
     */
    int countGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品信息
     * @param hotGoodsCode
     * @return 修改结果
     */
    HotGoodsMes findHotGoods(@Param("hotGoodsCode") String hotGoodsCode);

    /**
     * 获取所有热门商品信息
     * @param hotGoodsList
     * @return
     */
    List<HotGoodsList> listHotGoods(HotGoodsList hotGoodsList);

    /**
     * 修改热门商品
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 删除热门商品
     * @param listCode 热门商品信息集合
     * @param userId
     * @return
     */
    int deleteHotGoods(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 查询热门商品信息
     * @param hotGoodsShow1
     * @return 修改结果
     */
    HotGoodsShow findShowNumber(HotGoodsShow hotGoodsShow1);

    /**
     * 修改展示商品数量
     * @param showNumber
     * @return
     */
    int updateShowNumber(@Param("showNumber") int showNumber, @Param("userCode") String userCode);

}
