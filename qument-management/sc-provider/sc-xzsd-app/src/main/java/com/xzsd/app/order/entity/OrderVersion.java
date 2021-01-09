package com.xzsd.app.order.entity;

public class OrderVersion {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 版本号
     */
    private int version;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
