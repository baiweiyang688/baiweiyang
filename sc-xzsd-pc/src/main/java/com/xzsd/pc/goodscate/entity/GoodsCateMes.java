package com.xzsd.pc.goodscate.entity;

public class GoodsCateMes {
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 是否父类
     */
    private String isParent;
    /**
     * 版本
     */
    private String version;
    /**
     *
     */
    private String cateParentCode;

    public String getCateParentCode() {
        return cateParentCode;
    }

    public void setCateParentCode(String cateParentCode) {
        this.cateParentCode = cateParentCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

