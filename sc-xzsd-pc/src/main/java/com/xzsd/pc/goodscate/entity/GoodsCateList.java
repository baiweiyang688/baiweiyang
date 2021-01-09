package com.xzsd.pc.goodscate.entity;

import java.util.List;

public class GoodsCateList {
    /**
     * 分类名称
     */
     private String cateName;
    /**
     * 分类编码
     */
    private String cateCode;
    /**
     *版本
     */
    private String version;
    /**
     * 父类编码
     */
    private String cateParentCode;
    /**
     * 商品分类子类
     */
    private List<GoodsCateList> secondList;

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

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<GoodsCateList> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<GoodsCateList> secondList) {
        this.secondList = secondList;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
}
