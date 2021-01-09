package com.xzsd.app.goodsdetails.entity;

public class EvaContentInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 评价的商品
     */
    private String evaGoodsName;
    /**
     * 评价编号
     */
    private String evaCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 评价星级
     */
    private String evaLevel;
    /**
     * 评价内容
     */
    private String evaContent;
    /**
     * 评价时间
     */
    private String evaTime;
    /**
     * 评价人编号
     */
    private String custCode;
    /**
     * 评价人账号
     */
    private String custAcct;
    /**
     * 评价人头像
     */
    private String custImage;
    /**
     * 评价图片
     */
    private String evaImage;

    public String getCustImage() {
        return custImage;
    }

    public void setCustImage(String custImage) {
        this.custImage = custImage;
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

    public String getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(String evaTime) {
        this.evaTime = evaTime;
    }

    public String getEvaGoodsName() {
        return evaGoodsName;
    }

    public void setEvaGoodsName(String evaGoodsName) {
        this.evaGoodsName = evaGoodsName;
    }

    public String getEvaImage() {
        return evaImage;
    }

    public void setEvaImage(String evaImage) {
        this.evaImage = evaImage;
    }

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

    public String getEvaLevel() {
        return evaLevel;
    }

    public void setEvaLevel(String evaLevel) {
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

    public String getCustAcct() {
        return custAcct;
    }

    public void setCustAcct(String custAcct) {
        this.custAcct = custAcct;
    }
}
