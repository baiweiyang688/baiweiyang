package com.neusoft.webauth.goods.service;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.GoodsDao;
import com.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现功能类
 * @Author 张鑫
 * @Date 2020-03-27
 */



@Service
public class GoodsService {

//    @Autowired
//    private RedisOperator redisOperator;

    //    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @Autowired
//    private Destination queue;


    //映射资源
    @Resource
    private GoodsDao goodsDao;


    /**
     * 新增商品
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo) {
        //检验商品名称是否重复
        int countGoodsName = goodsDao.countGoodsName(goodsInfo);
        if (countGoodsName != 0) {
            return AppResponse.bizError("商品名称已存在，请重新输入");
        }
        //随机编号
//        goodsInfo.setGoodsCode(StringUtil.getCommonCode(3));
        String goodsCode = RandomUtil.randomHomework();
        goodsInfo.setGoodsCode(goodsCode);
        goodsInfo.setIsDeleted(0);
        int count = goodsDao.addGoods(goodsInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }

//        String json = JsonUtils.toJson(goodsInfo);
//        sendMessage(queue,json);
        return AppResponse.success("新增成功");
    }

//    private void sendMessage(Destination destination, final String message){
//        jmsMessagingTemplate.convertAndSend(destination, message);
//    }

    /**
     * 查询商品详情
     *
     * @param goodsCode
     * @return
     * @Author baiweiyang
     * @Date 2020-3-26
     */
    public AppResponse getGoodsByGoodsCode(String goodsCode) {
        GoodsInfo goodsInfo = goodsDao.getGoodsByGoodsCode(goodsCode);
        return AppResponse.success("查询成功！", goodsInfo);
    }

    /**
     * demo 查询用户列表（分页）
     *
     * @param goodsInfo
     * @return
     * @Author baiweiyang
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        String goodsName = goodsInfo.getGoodsName();
        String keyname = goodsName;
        //为空的
//        if (redisOperator.get(keyname) == null) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        String json = JSON.toJSONString(goodsInfoList);
//            redisOperator.set(keyname, json, 300);
        return AppResponse.success("查询成功！", pageData);
//        }else {
//            String goodsJson = redisOperator.get(keyname);
////            //转对象
//           List<GoodsInfo> jsonObject = JSONObject.parseArray(goodsJson,GoodsInfo.class);
//            return AppResponse.success("查询到Redis",jsonObject);
//        }
    }

    /**
     * demo 修改商品信息
     *
     * @param goodsInfo
     * @return
     * @Author baiweiyang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int countGoodsName = goodsDao.countGoodsName(goodsInfo);
        if (0 != countGoodsName) {
            return AppResponse.bizError("商品名称已存在，请重新输入");
        }
        //这里调用了数据库修改 数据库里version是条件，veision没有对应上则会弹出这句话，被其他人修改了
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * demo 删除商品信息
     *
     * @param goodsCode
     * @return
     * @Author baiweiyang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode, String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = goodsDao.deleteGoods(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
