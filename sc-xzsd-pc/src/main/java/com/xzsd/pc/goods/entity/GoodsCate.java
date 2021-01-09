package com.xzsd.pc.goods.entity;

public class GoodsCate {
    /**
     * 一级分类编码
     */
    private String oneLevelCode;
    /**
     * 一级分类名称
     */
    private String oneLevelName;
    /**
     * 二级分类编码
     */
    private String twoLevelCode;
    /**
     * 二级分类名称
     */
    private String twoLevelName;

    public String getOneLevelCode() {
        return oneLevelCode;
    }

    public void setOneLevelCode(String oneLevelCode) {
        this.oneLevelCode = oneLevelCode;
    }

    public String getOneLevelName() {
        return oneLevelName;
    }

    public void setOneLevelName(String oneLevelName) {
        this.oneLevelName = oneLevelName;
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
}
