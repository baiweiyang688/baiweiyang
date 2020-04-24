package com.xzsd.pc.store.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.AddressInfo;
import com.xzsd.pc.store.entity.BossInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.viewpage.controller.ViewPageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 门店
 * @Author 张鑫
 * @Date 2020-4-13
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    public static final Logger logger =
            LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @param storeInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */

    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            //boss
            storeInfo.setCreateBy(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *查询门店详情
     * @param storeCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findStore")
    public AppResponse findGoods(String storeCode) {
        try {
            return storeService.findStore(storeCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店列表
     * @param storeInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore(StoreInfo storeInfo) {
        try {
            return storeService.listStore(storeInfo);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateStore")
    public AppResponse updateGoods(StoreInfo storeInfo){
        try {
            //获取修改者id
            String userCode = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userCode);
            storeInfo.setLastModifiedBy(userCode);
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storeCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeCode){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询省份下拉
     * @param addressInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findProvince")
    public AppResponse findProvince(AddressInfo addressInfo) {
        try {
            return storeService.findProvince(addressInfo);
        } catch (Exception e) {
            logger.error("查询省份下拉列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询市下拉
     * @param addressInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findCity")
    public AppResponse findCity(AddressInfo addressInfo) {
        try {
            return storeService.findCity(addressInfo);
        } catch (Exception e) {
            logger.error("查询市下拉列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询区下拉
     * @param addressInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findDistrict")
    public AppResponse findDistrict(AddressInfo addressInfo) {
        try {
            return storeService.findDistrict(addressInfo);
        } catch (Exception e) {
            logger.error("查询市下拉列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询店长下拉
     * @param bossInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findBoss")
    public AppResponse findBoss(BossInfo bossInfo) {
        try {
            return storeService.findBoss(bossInfo);
        } catch (Exception e) {
            logger.error("查询市下拉列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
