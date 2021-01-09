package com.viewpage.controller;

import com.alibaba.fastjson.JSON;
import com.goods.controller.GoodsController;
import com.goods.entity.GoodsInfo;
import com.goods.service.GoodsService;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.GoodsViewPageInfo;
import com.viewpage.entity.ViewPageInfo;
import com.viewpage.service.ViewPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 轮播图增删改查
 * @Author 张鑫
 * @Date 2020-3-30
 */
@RestController
@RequestMapping("/viewpage")
public class ViewPageController {
    //打印之中带有这个类名
    public static final Logger logger =
            LoggerFactory.getLogger(ViewPageController.class);

    @Resource
    private ViewPageService viewPageService;

    /**
     * 新增轮播图
     * @param viewPageInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */
    @PostMapping("addViewPage")
    public AppResponse addViewPage(ViewPageInfo viewPageInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            viewPageInfo.setCreateBy(userId);
            AppResponse appResponse = viewPageService.addViewPage(viewPageInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 启用、禁用录播图
     * @param viewPageCode
     * @return AppResponse
     * @author baiweiyang
     * @Date 2020-3-26
     */
    @PostMapping("updateViewPageState")
    public AppResponse updateViewPageState(String viewPageCode,String viewPageState){
        try {
            //获取修改者id
            String userCode = "51654644";
            return viewPageService.updateViewPageState(viewPageCode,userCode,viewPageState);
        }catch (Exception e){
            logger.error("修改轮播图状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表
     * @param viewPageInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listViewPage")
    public AppResponse listGoods(ViewPageInfo viewPageInfo) {
        try {
            return viewPageService.listViewPage(viewPageInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品信息
     * @param viewPageCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteViewPage")
    public AppResponse deleteGoods(String viewPageCode){
        try {
            String userId = AuthUtils.getCurrentUserId();
            return viewPageService.deleteViewPage(viewPageCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param goodsViewPageInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsViewPageInfo goodsViewPageInfo) {
        try {
            return viewPageService.listGoods(goodsViewPageInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
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
    public AppResponse findGoods(String goodsName,String goodsCode ) {
        try {
            return viewPageService.findGoods(goodsCode,goodsName);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询轮播图详情
     * @param viewPageCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findViewPage")
    public AppResponse findViewPage(String viewPageCode) {
        try {
            return viewPageService.findViewPage(viewPageCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
