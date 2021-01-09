package com.hotgoods.entity;

public class HotGoodsMes {
    /**
     * 热门位商品编号
     */
    private String hotGoodsCode;
    /**
     * 热门位商品排序
     */
    private int hotSort;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
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

    public int getHotSort() {
        return hotSort;
    }

    public void setHotSort(int hotSort) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
