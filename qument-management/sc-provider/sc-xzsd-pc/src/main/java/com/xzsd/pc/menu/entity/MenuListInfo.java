package com.xzsd.pc.menu.entity;

public class MenuListInfo {
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 菜单路径
     */
    private String menuPath;
    /**
     * 菜单编号
     */
    private String menuCode;

    public MenuListInfo(){

    }


    public MenuListInfo(String menuCode, String menuName, String menuPath, String comment){
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPath = menuPath;
        this.comment = comment;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}
