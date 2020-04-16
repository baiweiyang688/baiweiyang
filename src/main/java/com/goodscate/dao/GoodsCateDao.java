package com.goodscate.dao;

import com.goods.entity.GoodsInfo;
import com.goodscate.entity.GoodsCateInfo;
import com.goodscate.entity.GoodsCateList;
import com.goodscate.entity.GoodsCateMes;
import com.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCateDao {
    /**
     * 统计商品分类名称
     * @param goodsCateInfo
     * @return
     */
    int countCateName(GoodsCateInfo goodsCateInfo);

    /**
     * 新增商品分类
     * @return
     */
    int addGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 查询分类详情
     * @param  cateCode
     * @return 修改结果
     */
    GoodsCateMes findCate(@Param("cateCode") String cateCode);

    /**
     * 获取所有分类信息
     * @param goodsCateList
     * @return
     */
    List<GoodsCateList> listCate(GoodsCateList goodsCateList);

    /**
     * 修改分类
     * @param goodsCateInfo
     * @return
     */
    int updateCate(GoodsCateInfo goodsCateInfo);

    /**
     * 删除分类
     * @param listCode
     * @param userId
     * @return
     */
    int deleteCate(List<String> listCode, @Param("userId") String userId);





}
