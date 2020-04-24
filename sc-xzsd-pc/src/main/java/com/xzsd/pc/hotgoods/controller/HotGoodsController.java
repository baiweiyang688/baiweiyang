package com.xzsd.pc.hotgoods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsList;
import com.xzsd.pc.hotgoods.entity.HotGoodsShow;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @Description 热门商品
 * @Author 张鑫
 * @Date 2020-3-30
 */
//映射注释
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {

    public static final Logger logger =
            LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;


    /**
     * 新增商品
     * @param hotGoodsInfo
     * @Author 张鑫
     * @Date 2020-4-18
     */
    @PostMapping("addHotGoods")
    public AppResponse addGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateBy(userId);
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *查询热门商品详情
     * @param hotGoodsCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findHotGoods")
    public AppResponse findHotGoods(String hotGoodsCode) {
        try {
            return hotGoodsService.findHotGoods(hotGoodsCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表
     * @param hotGoodsList
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsList hotGoodsList) {
        try {
            return hotGoodsService.listHotGoods(hotGoodsList);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            //获取修改者id
            String userCode = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setLastModifiedBy(userCode);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("修改商品信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品信息
     * @param hotGoodsCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsCode){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotGoodsCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询展示数量详情
     * @param
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findShowNumber")
    public AppResponse findShowNumber(HotGoodsShow hotGoodsShow) {
        try {
            return hotGoodsService.findShowNumber(hotGoodsShow);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改展示数量信息
     * @param showNumber
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateShowNumber")
    public AppResponse updateShowNumber(int showNumber){
        try {
            //获取修改者id
            String userCode = "54das4da6";
            return hotGoodsService.updateShowNumber(showNumber,userCode);
        }catch (Exception e){
            logger.error("修改展示数量失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
