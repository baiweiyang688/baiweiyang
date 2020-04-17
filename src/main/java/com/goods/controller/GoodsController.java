package com.goods.controller;

import com.goods.entity.GoodsCate;
import com.goods.entity.GoodsInfo;
import com.goods.service.GoodsService;
import com.goodscate.entity.GoodsCateList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 商品增删改查
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/goods")
public class GoodsController {
    public static final Logger logger =
            LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品详情
     * @param goodsCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findGoods")
    public AppResponse findGoods(String goodsCode) {
        try {
            return goodsService.findGoods(goodsCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param goodsInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品信息
     * @param goodsInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        try {
            //获取修改者id
            String userCode = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userCode);
            goodsInfo.setLastModifiedBy(userCode);
            return goodsService.updateGoods(goodsInfo);
        }catch (Exception e){
            logger.error("修改商品信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品信息
     * @param goodsCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode){
        try {
            String userId = AuthUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询一级分类下拉
     * @param goodsCate
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "oneLevel")
    public AppResponse oneLevel(GoodsCate goodsCate) {
        try {
            return goodsService.oneLevel(goodsCate);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询二级分类下拉
     * @param goodsCate
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "twoLevel")
    public AppResponse twoLevel(GoodsCate goodsCate) {
        try {
            return goodsService.twoLevel(goodsCate);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     * @param goodsState
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateGoodsState")
    public AppResponse updateGoodsStatus(String goodsCode,String goodsState) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            AppResponse appResponse = goodsService.updateGoodsState(goodsCode,userId,goodsState);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品状态修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
