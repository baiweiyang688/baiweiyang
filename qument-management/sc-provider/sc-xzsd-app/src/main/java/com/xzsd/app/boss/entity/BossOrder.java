package com.xzsd.app.boss.entity;

import java.util.List;

public class BossOrder {
    /**
     * 商店编号合集
     */
    private List<String> listCode;
    /**
     * 登陆用户编号
     */
    private String userCode;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 支付状态
     */
    private int payState;
    /**
     * 顾客姓名
     */
    private String custName;
    /**
     * 顾客电话
     */
    private String custPhone;
    /**
     * 订单总价
     */
    private String orderTotalPrice;
    /**
     * 版本
     */
    private String version;
    /**
     * 订单商品集合
     */
    private List<BossOrderInfo> goodsList;

    public List<String> getListCode() {
        return listCode;
    }

    public void setListCode(List<String> listCode) {
        this.listCode = listCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BossOrderInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<BossOrderInfo> goodsList) {
        this.goodsList = goodsList;
    }
}
