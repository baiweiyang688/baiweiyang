package com.xzsd.app.order.entity;

public class OrderGoodsList {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品图片
     */
    private String goodsImage;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private String nowPrice;
    /**
     * 商品评价等级
     */
    private double evaLevel;
    /**
     * 下单时间
     */
    private String createTime;


    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public double getEvaLevel() {
        return evaLevel;
    }

    public void setEvaLevel(double evaLevel) {
        this.evaLevel = evaLevel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
