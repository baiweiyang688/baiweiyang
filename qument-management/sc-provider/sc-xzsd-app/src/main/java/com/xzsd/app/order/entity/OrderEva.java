package com.xzsd.app.order.entity;

import java.util.List;

public class OrderEva {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 当前用户编号
     */
    private String userCode;
    /**
     * 评价信息集合
     */
     private List<OrderEvaList> evaList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<OrderEvaList> getEvaList() {
        return evaList;
    }

    public void setEvaList(List<OrderEvaList> evaList) {
        this.evaList = evaList;
    }
}
