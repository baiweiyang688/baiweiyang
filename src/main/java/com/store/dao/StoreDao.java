package com.store.dao;

import com.goods.entity.GoodsInfo;
import com.store.entity.StoreInfo;
import com.user.entity.UserInfo;

public interface StoreDao {
    /**
     * 新增门店
     * @param storeInfo 门店信息
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 统计门店账号数量
     * @param storeInfo
     * @return
     */
    int countStoreAcct(StoreInfo storeInfo);



}
