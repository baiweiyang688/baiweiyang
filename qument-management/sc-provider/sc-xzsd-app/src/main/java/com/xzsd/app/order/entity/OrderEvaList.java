package com.xzsd.app.order.entity;

public class OrderEvaList {
    /**
     * 评论编号
     */
    private String evaCode;
    /**
     * 商品编号
     */
    private String goodsCode;;
    /**
     * 评价等级
     */
    private double evaLevel;
    /**
     * 评价内容
     */
    private String evaContent;
    /**
     * 评价顾客编号
     */
    private String custCode;

    public String getEvaCode() {
        return evaCode;
    }

    public void setEvaCode(String evaCode) {
        this.evaCode = evaCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public double getEvaLevel() {
        return evaLevel;
    }

    public void setEvaLevel(double evaLevel) {
        this.evaLevel = evaLevel;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
}
