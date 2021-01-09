package com.goodsdetails.dao;


import com.goodsdetails.entity.GoodsDetailsInfo;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailsDao {
    /**
     * 查询商品信息
     * @param goodsDetailsInfo
     * @return 修改结果
     */
    GoodsDetailsInfo findGoodsDetails(GoodsDetailsInfo goodsDetailsInfo);


}
