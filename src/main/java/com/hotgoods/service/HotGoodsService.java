package com.hotgoods.service;

import com.github.pagehelper.PageInfo;
import com.goods.entity.GoodsInfo;
import com.hotgoods.dao.HotGoodsDao;
import com.hotgoods.entity.HotGoodsInfo;
import com.viewpage.dao.ViewPageDao;
import com.viewpage.entity.GoodsViewPageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.RandomUtil;

import javax.annotation.Resource;
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
        String hotGoodsCode = RandomUtil.randomHomework();
        hotGoodsInfo.setHotGoodsCode(hotGoodsCode);
        hotGoodsInfo.setIsDeleted(0);
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }



}
