package com.order.dao;

import com.goods.entity.GoodsInfo;
import com.order.entity.OrderInfo;
import com.order.entity.OrderList;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import util.AppResponse;

import java.util.List;

public interface OrderDao {
    /**
     * 获取所有订单信息
     * @param orderList
     * @return
     */
    List<OrderList> listOrder(OrderList orderList);

    /**
     * 查询订单详情
     * @param orderCode
     * @return 修改结果
     */
    OrderInfo findOrder(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param userId
     * @param orderState
     * @return
     */
    int updateOrderState(@Param("listCode") List<String> listCode,@Param("userId") String userId,@Param("orderState") String orderState);


}
