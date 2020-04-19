package com.hotgoods.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.entity.GoodsInfo;
import com.hotgoods.dao.HotGoodsDao;
import com.hotgoods.entity.HotGoodsInfo;
import com.hotgoods.entity.HotGoodsList;
import com.hotgoods.entity.HotGoodsMes;
import com.hotgoods.entity.HotGoodsShow;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.GoodsViewPageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.RandomUtil;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotGoodsService {

    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo) {
        //检验热门商品排序是否重复
        int countGoodsName = hotGoodsDao.countHotSort(hotGoodsInfo);
        if (countGoodsName != 0) {
            return AppResponse.bizError("当前热门排序序号已存在，请重新输入");
        }
        int countGoods = hotGoodsDao.countGoods(hotGoodsInfo);
        if (countGoods != 0) {
            return AppResponse.bizError("当前商品已是热门商品，请重新选择商品");
        }
        String hotGoodsCode = StringUtil.getCommonCode(2);
        hotGoodsInfo.setHotGoodsCode(hotGoodsCode);
        hotGoodsInfo.setIsDeleted(0);
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询热门商品详情
     * @param hotGoodsCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findHotGoods(String hotGoodsCode) {
        HotGoodsMes hotGoodsMes = hotGoodsDao.findHotGoods(hotGoodsCode);
        return AppResponse.success("查询成功！", hotGoodsMes);
    }

    /**
     * demo 查询热门商品列表（分页）
     * @param hotGoodsList
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsList hotGoodsList) {
        PageHelper.startPage(hotGoodsList.getPageNum(), hotGoodsList.getPageSize());
        List<HotGoodsList> goodsInfoList = hotGoodsDao.listHotGoods(hotGoodsList);
        PageInfo<HotGoodsList> pageData = new PageInfo<HotGoodsList>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        HotGoodsMes hotGoodsMes = hotGoodsDao.findHotGoods(hotGoodsInfo.getHotGoodsCode());
        //比较原热门排序序号跟原序号是否相等
        if(hotGoodsMes.getHotSort() != hotGoodsInfo.getHotSort()){
            int countHotSort = hotGoodsDao.countHotSort(hotGoodsInfo);
            if(0 != countHotSort){
                return AppResponse.bizError("修改的热门商品序号已存在,请重新输入");
            }
        }
        //判断商品编号
        if(!hotGoodsMes.getGoodsCode().equals(hotGoodsInfo.getGoodsCode())){
            int countGoodsCode = hotGoodsDao.countGoods(hotGoodsInfo);
            if(0 != countGoodsCode){
                return AppResponse.bizError("修改的商品编号已经是热门商品，请重新输入");
            }
        }
        //这里调用了数据库修改 数据库里version是条件，veision没有对应上则会弹出这句话，被其他人修改了
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * demo 删除热门商品信息
     * @param hotGoodsCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsCode, String userId) {
        List<String> listCode = Arrays.asList(hotGoodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = hotGoodsDao.deleteHotGoods(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


    /**
     * 查询展示数量详情
     * @param hotGoodsShow
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findShowNumber(HotGoodsShow hotGoodsShow) {
        HotGoodsShow hotGoodsShow1 = hotGoodsDao.findShowNumber(hotGoodsShow);
        return AppResponse.success("查询成功！",hotGoodsShow1);
    }

    /**
     * 修改展示数量信息
     * @param showNumber
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShowNumber(int showNumber,String userCode) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //这里调用了数据库修改 数据库里version是条件，veision没有对应上则会弹出这句话，被其他人修改了
        int count = hotGoodsDao.updateShowNumber(showNumber,userCode);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }


}
