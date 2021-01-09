package com.goodscate.entity;

import java.util.List;

public class GoodsCateList {
    /**
     * 分类名称
     */
     private String cateName;
    /**
     * 商品分类子类
     */
    private List<GoodsCateList> secondList;
    /**
     * 分类编码
     */
    private String cateCode;

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
