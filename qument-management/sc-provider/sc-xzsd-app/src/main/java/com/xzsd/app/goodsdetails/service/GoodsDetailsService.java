package com.xzsd.app.goodsdetails.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goodsdetails.dao.GoodsDetailsDao;
import com.xzsd.app.goodsdetails.entity.EvaContentInfo;
import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsDetailsService {

    @Resource
    private GoodsDetailsDao goodsDetailsDao;

    /**
     * 查询App商品详情
     * @param goodsCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findGoodsDetails(String goodsCode) {
        List<GoodsDetailsInfo> goodsInfo =  goodsDetailsDao.findGoodsDetails(goodsCode);
        return AppResponse.success("查询成功！", goodsInfo);
    }

    /**
     * 查询App商品评价
     * @param evaContentInfo
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse listEvaContent(EvaContentInfo evaContentInfo) {
        if(evaContentInfo.getGoodsCode() == null || "".equals(evaContentInfo.getGoodsCode())){
            return AppResponse.bizError("请输入商品编号");
        }
        if(evaContentInfo.getEvaLevel() == null || "".equals(evaContentInfo.getEvaLevel())){
            return AppResponse.bizError("请传入评价等级");
        }
        PageHelper.startPage(evaContentInfo.getPageNum(), evaContentInfo.getPageSize());
        List<EvaContentInfo> evaContentInfos = goodsDetailsDao.listEvaContent(evaContentInfo);
        PageInfo<EvaContentInfo> pageData = new PageInfo<EvaContentInfo>(evaContentInfos);
        return AppResponse.success("查询成功！", pageData);
    }






}
