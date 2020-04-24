package com.xzsd.pc.viewpage.entity;
/**
 * @author 张鑫
 */
public class GoodsViewPageInfo {
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
     * 商品状态 1 在售 2 已下架 3 未发布
     */
    private String goodsState;
    /**
     * 一级分类名称
     */
    private String oneLevelName;
    /**
     * 二级分类名称
     */
    private String twoLevelName;

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

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
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
}
