package com.xzsd.pc.order.dao;


import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderList;
import org.apache.ibatis.annotations.Param;

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
     * @param orderInfo
     * @return 修改结果
     */
    List<OrderInfo> findOrder(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param userId
     * @param orderState
     * @return
     */
    int updateOrderState(@Param("listCode") List<String> listCode, @Param("userId") String userId, @Param("orderState") String orderState);


}
