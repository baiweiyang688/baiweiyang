package com.xzsd.app.shopcart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.goodsdetails.controller.GoodsDetailsController;
import com.xzsd.app.goodsdetails.service.GoodsDetailsService;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.home.entity.ViewPageAppInfo;
import com.xzsd.app.shopcart.entity.ShopCartInfo;
import com.xzsd.app.shopcart.entity.ShopCartList;
import com.xzsd.app.shopcart.service.ShopCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 购物车
 * @Author 张鑫
 * @Date 2020-4-20
 */
//映射注释
@RestController
@RequestMapping("/client")
public class ShopCartController {

    public static final Logger logger =
            LoggerFactory.getLogger(GoodsDetailsController.class);

    @Resource
    private ShopCartService shopCartService;

    /**
     * 加入到购物车
     * @param shopCartInfo
     * @Author 张鑫
     * @Date 2020-4-21
     */
    @PostMapping("addShopCart")
    public AppResponse addShopCart(ShopCartInfo shopCartInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            shopCartInfo.setCreateBy(userId);
            AppResponse appResponse = shopCartService.addShopCart(shopCartInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车列表
     * @param shopCartList
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listShopCart")
    public AppResponse listShopCart(ShopCartList shopCartList) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            shopCartList.setUserCode(userId);
            return shopCartService.listShopCart(shopCartList);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车清单信息
     * @param
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteShopCart")
    public AppResponse deleteShopCart(String shopCartCode){
        try {
            if(shopCartCode == null || "".equals(shopCartCode)){
                return  AppResponse.bizError("请传入购物车清单编号");
            }
            String userId = SecurityUtils.getCurrentUserId();
            return shopCartService.deleteShopCart(shopCartCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 修改购物车清单数量
     * @param
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateShopCart")
    public AppResponse updateShopCart(ShopCartInfo shopCartInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            shopCartInfo.setLastModifiedBy(userId);
            return shopCartService.updateShopCart(shopCartInfo);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }



}
