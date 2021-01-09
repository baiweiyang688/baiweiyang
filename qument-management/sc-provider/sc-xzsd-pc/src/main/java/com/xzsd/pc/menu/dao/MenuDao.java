package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuListInfo;
import com.xzsd.pc.menu.entity.MenuMesInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 统计菜单名称
     * @param menuInfo
     * @return
     */
    int countMenuName(MenuInfo menuInfo);

    /**
     * 查询菜单详情
     * @param menuCode 菜单编号
     * @return
     */
    MenuMesInfo findMenu(@Param("menuCode") String menuCode);

    /**
     * 获取所有菜单名称
     * @param menuListInfo
     * @return
     */
    List<MenuListInfo> listMenu(MenuListInfo menuListInfo);

    /**
     * 修改菜单信息
     * @param menuInfo
     * @return
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteMenu(@Param("listCode") List<String> listCode, @Param("userId") String userId);


}
