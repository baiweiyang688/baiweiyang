package com.xzsd.pc.store.entity;

public class AddressInfo {
    /**
     * 省Id
     */
    private String provinceId;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市Id
     */
    private String cityId;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区id
     */
    private String districtId;
    /**
     * 区名称
     */
    private String districtName;
    /**
     * 父类编码
     */
    private String parentCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
