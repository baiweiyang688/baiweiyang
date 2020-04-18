package com.hotgoods.dao;

import com.hotgoods.entity.HotGoodsInfo;
import com.user.entity.UserInfo;
import com.viewpage.entity.ViewPageInfo;

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

}
