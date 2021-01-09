package com.xzsd.pc.menu.entity;

public class MenuMesInfo {
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 是否菜单 0 菜单 1 目录
     */
    private String isMenu;
    /**
     * 备注
     */
    private String comment;
    /**
     * 菜单路径
     */
    private String menuPath;
    /**
     * 版本号
     */
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
