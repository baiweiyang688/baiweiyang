package com.driverapp.entity;

public class DriverMesInfo {
    /**
     * 司机头像
     */
    private String userHead;
    /**
     * 司机昵称
     */
    private String userNickName;
    /**
     * 司机姓名
     */
    private String userName;
    /**
     * 司机电话
     */
    private String userPhone;

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
