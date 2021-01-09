package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.RandomUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AddressInfo;
import com.xzsd.pc.store.entity.BossInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.LoginInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Resource
    private UserDao userDao;

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
        storeInfo.setInviteCode(RandomUtil.randomDriverCode());
        int countInviteCode = storeDao.countInviteCode(storeInfo);
        if(countInviteCode !=0 ){
            return AppResponse.bizError("门店邀请码已被使用，请再次点击新增随机门店邀请码！");
        }
        int countPhone = storeDao.countPhone(storeInfo);
        if(countPhone != 0){
            return AppResponse.bizError("门店电话已被使用，请重新输入门店电话！");
        }
        int countStoreAcct = storeDao.countStoreAcct(storeInfo);
        if(countStoreAcct != 0){
            return AppResponse.bizError("门店账号已存在，请再次点击新增随机门店账号！");
        }
        int countLicense = storeDao.countLicence(storeInfo);
        if(countLicense != 0){
            return AppResponse.bizError("门店营业执照已被使用，请重新输入！");
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
        //通过findlogin获取当前登录人的角色role
        String userCode = SecurityUtils.getCurrentUserId();
        LoginInfo userInfoStore = userDao.findLogin(userCode);
        //设置角色
        storeInfo.setUserRole(userInfoStore.getUserRole());
        //设置当前角色编号
        storeInfo.setUserCode(userInfoStore.getLoginCode());
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
        int countPhone = storeDao.countPhone(storeInfo);
        if(countPhone != 0){
            return AppResponse.bizError("门店电话已被使用，请重新输入门店电话！");
        }
        int countLicense = storeDao.countLicence(storeInfo);
        if(countLicense != 0){
            return AppResponse.bizError("门店营业执照已被使用，请重新输入！");
        }
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
