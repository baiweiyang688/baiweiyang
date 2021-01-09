package com.xzsd.pc.store.entity;

import java.util.Date;

public class StoreMesInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 联系电话
     */
    private String storePhone;
    /**
     * 详细地址
     */
    private String storeAddress;
    /**
     * 店长姓名
     */
    private String bossName;
    /**
     * 门店邀请码
     */
    private String storeInviteCode;
    /**
     * 店长编号
     */
    private String bossCode;
    /**
     * 营业执照编码
     */
    private String storeLicence;
    /**
     * 省份id
     */
    private String provinceId;
    /**
     * 城市id
     */
    private String cityId;
    /**
     * 区id
     */
    private String districtId;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private int version;
}
