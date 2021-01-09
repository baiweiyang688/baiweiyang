package com.neusoft.webauth.goods.entity;

import java.util.Date;

/**
 * @author 张鑫
 */

public class GoodsInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品浏览量
     */
    private int goodsPageView;
    /**
     * 商品销量
     */
    private int goodsSales;
    /**
     * 商品状态 0 在售 1 已下架 2 未发布
     */
    private String goodsState;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品图片
     */
    private String goodsImage;
    /**
     * 商家名称
     */
    private String bossName;
    /**
     * 商家代码
     */
    private String bossCode;
    /**
     * 一级分类代码
     */
    private String oneLevelCode;
    /**
     * 二级分类代码
     */
    private String twoLevelCode;
    /**
     * 一级分类名称
     */
    private String oneLevelName;
    /**
     * 二级分类名称
     */
    private String twoLevelName;
    /**
     * isbn书号
     */
    private String isbnBookNum;
    /**
     * 广告词
     */
    private String adWord;
    /**
     * 库存
     */
    private String inventory;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     * 在售价
     */
    private String nowPrice;
    /**
     * 上架时间
     */
    private String uploadTime;
    /**
     * 出版社
     *
     */
    private String publisher;
    /**
     * 作者
     */
    private String author;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private int version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public int getGoodsPageView() {
        return goodsPageView;
    }

    public void setGoodsPageView(int goodsPageView) {
        this.goodsPageView = goodsPageView;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
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

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossCode() {
        return bossCode;
    }

    public void setBossCode(String bossCode) {
        this.bossCode = bossCode;
    }

    public String getOneLevelCode() {
        return oneLevelCode;
    }

    public void setOneLevelCode(String oneLevelCode) {
        this.oneLevelCode = oneLevelCode;
    }

    public String getTwoLevelCode() {
        return twoLevelCode;
    }

    public void setTwoLevelCode(String twoLevelCode) {
        this.twoLevelCode = twoLevelCode;
    }

    public String getOneLevelName() {
        return oneLevelName;
    }

    public void setOneLevelName(String oneLevelName) {
        this.oneLevelName = oneLevelName;
    }

    public String getTwoLevelName() {
        return twoLevelName;
    }

    public void setTwoLevelName(String twoLevelName) {
        this.twoLevelName = twoLevelName;
    }

    public String getIsbnBookNum() {
        return isbnBookNum;
    }

    public void setIsbnBookNum(String isbnBookNum) {
        this.isbnBookNum = isbnBookNum;
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
