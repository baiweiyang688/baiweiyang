package com.xzsd.pc.goodscate.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.RandomUtil;
import com.xzsd.pc.goodscate.dao.GoodsCateDao;
import com.xzsd.pc.goodscate.entity.GoodsCateInfo;
import com.xzsd.pc.goodscate.entity.GoodsCateList;
import com.xzsd.pc.goodscate.entity.GoodsCateMes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Service
public class GoodsCateService {

    @Resource
    private GoodsCateDao goodsCateDao;

    /**
     * 新增商品分类
     * @param goodsCateInfo
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsCate(GoodsCateInfo goodsCateInfo) {
        //0表示一级分类 1表示二级分类
        if (goodsCateInfo.getIsParent() != 1 && goodsCateInfo.getIsParent() != 0){
            return AppResponse.bizError("请重新输入0或1表示商品分类级别!");
        }
        if(goodsCateInfo.getIsParent() == 1){
            if(goodsCateInfo.getCateParentCode() == "" ){
                return AppResponse.bizError("请输入父类的编号");
            }
        } else if (goodsCateInfo.getIsParent() == 0){
            if(goodsCateInfo.getCateParentCode() != "" ){
                return AppResponse.bizError("已是父类，请不要输入父类编号");
            }
        }

        goodsCateInfo.setCateCode(RandomUtil.randomDriverCode());
        goodsCateInfo.setIsDeleted(0);
        int countCateName = goodsCateDao.countCateName(goodsCateInfo);
        if(countCateName != 0){
            return AppResponse.bizError("商品分类名称已存在，请重新输入！");
        }
        int count = goodsCateDao.addGoodsCate(goodsCateInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询分类详情
     * @param cateCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findCate(String cateCode) {
        GoodsCateMes goodsCateInfo = goodsCateDao.findCate(cateCode);
        return AppResponse.success("查询成功！", goodsCateInfo);
    }

    /**
     * 修改分类信息
     * @param goodsCateInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCate(GoodsCateInfo goodsCateInfo) {
        if (goodsCateInfo.getCateCode() == null || "".equals(goodsCateInfo.getCateCode())){
            return AppResponse.bizError("请输入分类的编号");
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = goodsCateDao.updateCate(goodsCateInfo);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 删除分类
     * @param cateCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCate(String cateCode, String userId) {
        List<String> listCode = Arrays.asList(cateCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = goodsCateDao.deleteCate(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询一二级分类
     * @param goodsCateList
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listCate")
    public AppResponse listCate(GoodsCateList goodsCateList) {
        List<GoodsCateList> goodsCateMesList = goodsCateDao.listCate(goodsCateList);
        return AppResponse.success("查询成功！", goodsCateMesList);
    }

}
