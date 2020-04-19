package com.viewpage.entity;

public class ViewPageMes {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 轮播图编号
     */
    private String viewPageCode;
    /**
     * 轮播图状态 1启用，2已禁用，3全部
     */
    private int viewPageState;
    /**
     * 轮播图序号
     */
    private String viewPageNum;
    /**
     * 轮播图路径
     */
    private String viewPagePath;
    /**
     * 有效期起
     */
    private String startTime;
    /**
     * 有效期止
     */
    private String endTime;
    /**
     * 商品信息
     */
    private String goodsCode;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private String updateTime;
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

    public String getViewPageCode() {
        return viewPageCode;
    }

    public void setViewPageCode(String viewPageCode) {
        this.viewPageCode = viewPageCode;
    }

    public int getViewPageState() {
        return viewPageState;
    }

    public void setViewPageState(int viewPageState) {
        this.viewPageState = viewPageState;
    }

    public String getViewPageNum() {
        return viewPageNum;
    }

    public void setViewPageNum(String viewPageNum) {
        this.viewPageNum = viewPageNum;
    }

    public String getViewPagePath() {
        return viewPagePath;
    }

    public void setViewPagePath(String viewPagePath) {
        this.viewPagePath = viewPagePath;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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
