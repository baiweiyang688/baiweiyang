package com.store.dao;

import com.goods.entity.GoodsInfo;
import com.store.entity.StoreInfo;
import com.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreDao {
    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 统计门店账号数量
     * @param storeInfo
     * @return
     */
    int countStoreAcct(StoreInfo storeInfo);

    /**
     * 查询门店信息
     * @param storeCode 门店编号
     * @return
     */
    StoreInfo findStore(@Param("storeCode") String storeCode);

    /**
     * 获取所有门店信息
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStore(StoreInfo storeInfo);

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除门店信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteStore(List<String> listCode,@Param("userId") String userId);




}
