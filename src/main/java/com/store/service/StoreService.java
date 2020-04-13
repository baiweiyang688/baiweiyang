package com.store.service;

import com.store.dao.StoreDao;
import com.store.entity.StoreInfo;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.ViewPageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.AppResponse;
import util.RandomUtil;
import util.StringUtil;

import javax.annotation.Resource;

@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     * @param storeInfo
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo) {
        //设置门店编号和门店账号为4位随机英文字母加随机的三位数
        storeInfo.setStoreCode(RandomUtil.randomDriverCode());
        storeInfo.setIsDeleted(0);
        storeInfo.setStoreAcct(RandomUtil.randomDriverCode());
        int countStoreAcct = storeDao.countStoreAcct(storeInfo);
        if(countStoreAcct != 0){
            return AppResponse.bizError("门店账号已存在，请重新输入！");
        }

        int count = storeDao.addStore(storeInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }

}
