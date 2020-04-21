package com.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.entity.GoodsCate;
import com.goods.entity.GoodsInfo;
import com.store.dao.StoreDao;
import com.store.entity.AddressInfo;
import com.store.entity.BossInfo;
import com.store.entity.StoreInfo;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.ViewPageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.AuthUtils;
import util.RandomUtil;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 商店实现功能类
 * @Author 张鑫
 * @Date 2020-03-25
 */
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

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    public AppResponse findStore(String storeCode) {
        StoreInfo storeInfo = storeDao.findStore(storeCode);
        return AppResponse.success("查询成功！", storeInfo);
    }

    /**
     * 查询门店（分页）
     * @param storeInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore(StoreInfo storeInfo) {
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        List<StoreInfo> storeInfos = storeDao.listStore(storeInfo);
        PageInfo<StoreInfo> pageData = new PageInfo<StoreInfo>(storeInfos);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 删除门店信息
     * @param storeCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeCode, String userId) {
        List<String> listCode = Arrays.asList(storeCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = storeDao.deleteStore(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询省份下拉
     * @param addressInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "findProvince")
    public AppResponse findProvince(AddressInfo addressInfo) {
        List<AddressInfo> addressInfos = storeDao.findProvince(addressInfo);
        return AppResponse.success("查询成功！", addressInfos);
    }

    /**
     * 查询市下拉
     * @param addressInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "findCity")
    public AppResponse findCity(AddressInfo addressInfo) {
        List<AddressInfo> addressInfos = storeDao.findCity(addressInfo);
        return AppResponse.success("查询成功！", addressInfos);
    }

    /**
     * 查询区下拉
     * @param addressInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "findDistrict")
    public AppResponse findDistrict(AddressInfo addressInfo) {
        List<AddressInfo> addressInfos = storeDao.findDistrict(addressInfo);
        return AppResponse.success("查询成功！", addressInfos);
    }

    /**
     * 查询店长下拉
     * @param
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "findBoss")
    public AppResponse findBoss(BossInfo bossInfo) {
        List<BossInfo> addressInfos = storeDao.findBoss(bossInfo);
        return AppResponse.success("查询成功！", addressInfos);
    }

}
