package com.xzsd.app.goodsdetails.entity;

public class GoodsDetailsInfo {
    /**
     * 当前用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品现价
     */
    private String nowPrice;
    /**
     * 商品原价
     */
    private String costPrice;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品图片路径
     */
    private String goodsImage;
    /**
     * 商品销量
     */
    private String goodsSales;
    /**
     * 商品库存
     */
    private int inventory;
    /**
     * 商品浏览量
     */
    private int goodsPageView;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 作者
     */
    private String author;
    /**
     * 绑定的门店编号
     */
    private String storeCode;
    /**
     * 绑定的门店名称
     */
    private String storeName;
    /**
     * 绑定的门店地址
     */
    private String storeAddress;
    /**
     * 上架的时间
     */
    private String uploadTime;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(String goodsSales) {
        this.goodsSales = goodsSales;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getGoodsPageView() {
        return goodsPageView;
    }

    public void setGoodsPageView(int goodsPageView) {
        this.goodsPageView = goodsPageView;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

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
}
