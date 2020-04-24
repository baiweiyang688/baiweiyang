package com.xzsd.app.home.entity;

import java.util.List;

public class TwoLevel {
    /**
     * 二级分类编号
     */
    private String twoLevelCode;
    /**
     * 二级分类名称
     */
    private String twoLevelName;
    /**
     * 分类编号
     */
    private String cateParentCode;
    /**
     * 分类信息集合
     */
    private List<GoodsList>  goodsList;

    public List<GoodsList> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsList> goodsList) {
        this.goodsList = goodsList;
    }

    public String getTwoLevelCode() {
        return twoLevelCode;
    }

    public void setTwoLevelCode(String twoLevelCode) {
        this.twoLevelCode = twoLevelCode;
    }

    public String getTwoLevelName() {
        return twoLevelName;
    }

    public void setTwoLevelName(String twoLevelName) {
        this.twoLevelName = twoLevelName;
    }

    public String getCateParentCode() {
        return cateParentCode;
    }

    public void setCateParentCode(String cateParentCode) {
        this.cateParentCode = cateParentCode;
    }
}
