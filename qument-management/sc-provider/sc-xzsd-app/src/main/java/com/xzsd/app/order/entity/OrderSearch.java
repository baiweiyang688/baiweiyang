package com.xzsd.app.order.entity;

import java.util.List;

/**
 * @author 百未央
 */

public class OrderSearch{
    /**
     * 商家名称
     */
    private String storeName;
    /**
     * 商家地址
     */
    private String storeAddress;
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
     * 创建时间
     */
    private String createTime;
    /**
     * 订单总价格
     */
    private String orderTotalPrice;
    /**
     * 订单商品内容详情
     */
    private List<OrderListMes> goodsList;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
