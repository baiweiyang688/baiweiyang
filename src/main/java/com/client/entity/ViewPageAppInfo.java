package com.client.entity;

public class ViewPageAppInfo {
    /**
     * 轮播图路径
     */
    private String viewPagePath;
    /**
     * 轮播图序号
     */
    private String viewPageNum;
    /**
     * 轮播图编号
     */
    private String viewPageCode;
    /**
     * 商品编号
     */
    private String goodsCode;

    public String getViewPagePath() {
        return viewPagePath;
    }

    public void setViewPagePath(String viewPagePath) {
        this.viewPagePath = viewPagePath;
    }

    public String getViewPageNum() {
        return viewPageNum;
    }

    public void setViewPageNum(String viewPageNum) {
        this.viewPageNum = viewPageNum;
    }

    public String getViewPageCode() {
        return viewPageCode;
    }

    public void setViewPageCode(String viewPageCode) {
        this.viewPageCode = viewPageCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
