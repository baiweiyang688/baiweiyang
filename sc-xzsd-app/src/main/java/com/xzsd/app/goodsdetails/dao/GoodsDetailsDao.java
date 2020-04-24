package com.xzsd.app.goodsdetails.dao;


import com.xzsd.app.goodsdetails.entity.EvaContentInfo;
import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDetailsDao {
    /**
     * 查询商品信息
     * @param goodsCode
     * @return 修改结果
     */
   List<GoodsDetailsInfo> findGoodsDetails(@Param("goodsCode") String goodsCode);

    /**
     * 查询评价内容
     * @param evaContentInfo
     * @return 修改结果
     */
    List<EvaContentInfo> listEvaContent(EvaContentInfo evaContentInfo);



}
