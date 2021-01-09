package com.xzsd.app.order.entity;

import java.util.List;

public class OrderList {
    /**
     * 登录用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 支付状态
     */
    private int payState;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 订单总价格
     */
    private String orderTotalPrice;
    /**
     * 订单商品内容详情
     */
    private List<OrderListMes> goodsList;
    /**
     * 版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public List<OrderListMes> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderListMes> goodsList) {
        this.goodsList = goodsList;
    }
}
