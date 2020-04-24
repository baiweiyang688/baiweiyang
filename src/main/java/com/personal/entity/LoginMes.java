package com.personal.entity;

public class LoginMes {
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 用户头像图片路径
     */
    private String userImage;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户角色
     */
    private int userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
