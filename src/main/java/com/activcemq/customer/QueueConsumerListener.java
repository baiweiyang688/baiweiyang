//package com.activcemq.customer;
//
//import com.goods.dao.GoodsDao;
//import com.goods.entity.MqInfo;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//import util.JsonUtils;
//import util.StringUtil;
//
//import javax.annotation.Resource;
//
//@Component
//public class QueueConsumerListener {
//
//    @Resource
//    private GoodsDao goodsDao;
//
//    //queue模式的消费者
//    @JmsListener(destination="${spring.jms.queue-name}", containerFactory="queueListener")
//    public void readActiveQueue(String message) {
//        MqInfo mqInfo;
//        mqInfo = JsonUtils.fromJson(message,MqInfo.class);
//        mqInfo.setCode(StringUtil.getCommonCode(2));
//        mqInfo.setContent(message);
//        int count = goodsDao.addMessage(mqInfo);
//        if (count > 0) {
//            System.out.println("queue接受到：" + message);
//        }
//    }
//}
