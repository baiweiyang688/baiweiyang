package com.xzsd.pc.hotgoods.entity;

public class HotGoodsList {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 热门商品编号
     */
    private String hotGoodsCode;
    /**
     * 热门位商品排序
     */
    private String hotSort;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private String nowPrice;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 版本号
     */
    private int version;

    public String getHotGoodsCode() {
        return hotGoodsCode;
    }

    public void setHotGoodsCode(String hotGoodsCode) {
        this.hotGoodsCode = hotGoodsCode;
    }

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

    public String getHotSort() {
        return hotSort;
    }

    public void setHotSort(String hotSort) {
        this.hotSort = hotSort;
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

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
