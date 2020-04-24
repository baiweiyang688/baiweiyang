package com.goodsdetails.service;

import com.goods.entity.GoodsInfo;
import com.goodsdetails.dao.GoodsDetailsDao;
import com.goodsdetails.entity.GoodsDetailsInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;

import javax.annotation.Resource;

@Service
public class GoodsDetailsService {

    @Resource
    private GoodsDetailsDao goodsDetailsDao;

    /**
     * 查询App商品详情
     * @param goodsDetailsInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findGoodsDetails(GoodsDetailsInfo goodsDetailsInfo) {
        GoodsDetailsInfo goodsInfo = goodsDetailsDao.findGoodsDetails(goodsDetailsInfo);
        return AppResponse.success("查询成功！", goodsInfo);
    }






}
