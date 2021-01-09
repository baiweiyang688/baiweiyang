package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    int addOrder(OrderInfo orderInfo);

    /**
     * 新增订单详情
     * @param orderMesList
     * @return
     */
    int addOrderMes(@Param("orderMesList") List<OrderMes> orderMesList);

    /**
     * 更新商品库存
     * @param orderInventory
     * @return
     */
    int updateInventory(@Param("orderMesList") List<OrderMes> orderInventory);

    /**
     * 更新商品库存订单取消的时候
     * @param orderInventory
     * @return
     */
    int updateInventoryTwo(@Param("orderMesList") List<OrderListMes> orderInventory);


    /**
     * 查询订单列表
     * @param orderList
     * @return
     */
    List<OrderList> listOrder(OrderList orderList);

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    List<OrderSearch> findOrder(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param orderUpdate
     * @return
     */
    int updateOrderState(OrderUpdate orderUpdate);

    /**
     * 新增商品评价
     * @param orderEvaLists
     * @param orderCode
     * @return
     */
    int addOrderGoodsEva(@Param("list")List<OrderEvaList> orderEvaLists, @Param("orderCode")String orderCode);

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    OrderVersion findVersion(@Param("orderCode") String orderCode);


    /**
     * 更新商品星级
     * @param orderEva
     * @return
     */
    int updateGoodLevel(@Param("listLevel")List<OrderEvaList> orderEva);

    /**
     * 获取所有商品信息
     * @param orderCode
     * @return
     */
    List<OrderGoodsList> orderGoodsList(@Param("orderCode") String orderCode);

}
