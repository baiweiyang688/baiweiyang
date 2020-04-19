package com.viewpage.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.entity.GoodsInfo;
import com.viewpage.entity.GoodsViewPageInfo;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.ViewPageInfo;
import com.viewpage.entity.ViewPageMes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现功能类
 * @Author 张鑫
 * @Date 2020-03-27
 */
@Service
public class ViewPageService {

    @Resource
    private ViewPageDao viewPageDao;

    /**
     * 新增轮播图
     * @param viewPageInfo
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addViewPage(ViewPageInfo viewPageInfo) {
        //判断轮播图输入的排序是否在数据库存在
            int count2 = viewPageDao.countViewPageNum(viewPageInfo);
            if (0 != count2){
                return AppResponse.bizError("新增的轮播图序号已经存在，请重新设置轮播图序号");
            }
//        }
       if(viewPageInfo.getViewPageState() == 0){
           viewPageInfo.setViewPageState(1);
       }

        //随机编号
        viewPageInfo.setViewPageCode(StringUtil.getCommonCode(2));
        viewPageInfo.setIsDeleted(0);
        int count = viewPageDao.addViewPage(viewPageInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 启用、禁用轮播图
     * @param viewPageState
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateViewPageState(String viewPageCode,String userId,String viewPageState) {
        List<String> listCode = Arrays.asList(viewPageCode.split(","));
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = viewPageDao.updateViewPageState(listCode,userId,viewPageState);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }


    /**
     * demo 查询轮播图（分页）
     * @param viewPageInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listViewPage")
    public AppResponse listViewPage(ViewPageInfo viewPageInfo) {
        PageHelper.startPage(viewPageInfo.getPageNum(), viewPageInfo.getPageSize());
        List<ViewPageInfo> viewPageInfoList = viewPageDao.listViewPage(viewPageInfo);
        PageInfo<ViewPageInfo> pageData = new PageInfo<ViewPageInfo>(viewPageInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除轮播图
     * @param viewPageCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteViewPage(String viewPageCode, String userId) {
        List<String> listViewPage = Arrays.asList(viewPageCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = viewPageDao.deleteViewPage(listViewPage, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询商品列表
     * @param goodsViewPageInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsViewPageInfo goodsViewPageInfo) {
        List<GoodsViewPageInfo> goodsInfoList = viewPageDao.listGoods(goodsViewPageInfo);
        PageInfo<GoodsViewPageInfo> pageData = new PageInfo<GoodsViewPageInfo>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findGoods(String goodsName,String goodsCode) {
        if(null == goodsCode || null == goodsName){
            return AppResponse.bizError("商品编码或商品名称不能为空");
        }
        GoodsViewPageInfo goodsViewPageInfo = viewPageDao.findGoods(goodsCode,goodsName);
        return AppResponse.success("查询成功！", goodsViewPageInfo);
    }


    /**
     * 查询轮播图详情
     * @param viewPageCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findViewPage(String viewPageCode) {
        ViewPageMes viewPageInfo = viewPageDao.findViewPage(viewPageCode);
        return AppResponse.success("查询成功！", viewPageInfo);
    }

//    @Transactional(rollbackFor = Exception.class)
//    public AppResponse updateViewPageState(ViewPageInfo viewPageInfo) {
//        AppResponse appResponse = AppResponse.success("修改成功");
//        List<ViewPageInfo> state = viewPageDao.getViewPageState(viewPageInfo);
//        String json = JSON.toJSONString(state);
//        String a = json.substring(json.lastIndexOf(":")+1,json.indexOf("}"));
//        int nowstate = Integer.parseInt(a);
//        System.out.println(nowstate);
//        if(nowstate == 0 || nowstate == 2){
//            viewPageInfo.setViewPageState(1);
//        }else if(nowstate == 1){
//            viewPageInfo.setViewPageState(2);
//        }
//        int count = viewPageDao.updateViewPageState(viewPageInfo);
//        if (0 == count) {
//            return AppResponse.success("数据有变化，请刷新！");
//        }
//        return appResponse;
//    }




}
