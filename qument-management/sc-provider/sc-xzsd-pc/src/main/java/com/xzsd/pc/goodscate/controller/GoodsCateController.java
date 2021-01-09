package com.xzsd.pc.goodscate.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.goodscate.entity.GoodsCateInfo;
import com.xzsd.pc.goodscate.entity.GoodsCateList;
import com.xzsd.pc.goodscate.entity.OneLevel;
import com.xzsd.pc.goodscate.service.GoodsCateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @Description 商品分类
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/goodsCate")
public class GoodsCateController {

    public static final Logger logger =
            LoggerFactory.getLogger(GoodsCateController.class);

    @Resource
    private GoodsCateService goodsCateService;

    /**
     * 新增商品分类
     * @param goodsCateInfo
     * @Author 张鑫
     * @Date 2020-3-25
     */
    @PostMapping("addGoodsCate")
    public AppResponse addGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goodsCateInfo.setCreateBy(userId);
            AppResponse appResponse = goodsCateService.addGoodsCate(goodsCateInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询分类详情
     * @param cateCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findCate")
    public AppResponse findGoods(String cateCode) {
        try {
            return goodsCateService.findCate(cateCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改分类信息
     * @param goodsCateInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateCate")
    public AppResponse updateCate(GoodsCateInfo goodsCateInfo){
        try {
            //获取修改者id
            String userCode = SecurityUtils.getCurrentUserId();
            goodsCateInfo.setCreateBy(userCode);
            goodsCateInfo.setLastModifiedBy(userCode);
            return goodsCateService.updateCate(goodsCateInfo);
        }catch (Exception e){
            logger.error("修改门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除分类
     * @param cateCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteCate")
    public AppResponse deleteCate(String cateCode){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return goodsCateService.deleteCate(cateCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询分类列表
     * @param goodsCateList
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listCate")
    public AppResponse listCate(GoodsCateList goodsCateList) {
        try {
            return goodsCateService.listCate(goodsCateList);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询一级分类
     * @param oneLevel
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "oneLevel")
    public AppResponse oneLevel(OneLevel oneLevel) {
        try {
            return goodsCateService.oneLevel(oneLevel);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
