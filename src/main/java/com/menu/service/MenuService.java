package com.menu.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.entity.GoodsInfo;
import com.menu.dao.MenuDao;
import com.menu.entity.MenuInfo;
import com.menu.entity.MenuListInfo;
import com.menu.entity.MenuMesInfo;
import com.store.dao.StoreDao;
import com.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;
import util.RandomUtil;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     * @param menuInfo
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo){
        menuInfo.setMenuCode(StringUtil.getCommonCode(2));
        int countMenuName = menuDao.countMenuName(menuInfo);
        if (0 != countMenuName) {
            return AppResponse.bizError("菜单名称已存在，请重新输入！");
        }
        int count=menuDao.addMenu(menuInfo);
        if (0 == count){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findMenu(String menuCode) {
        MenuMesInfo menuMesInfo = menuDao.findMenu(menuCode);
        return AppResponse.success("查询成功！", menuMesInfo);
    }

    /**
     * 查询菜单
     * @param menuListInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-8
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu(MenuListInfo menuListInfo) {
        List<MenuListInfo> menuListInfoList = menuDao.listMenu(menuListInfo);
        return AppResponse.success("查询成功！", menuListInfoList);
    }

    /**
     * 修改菜单信息
     * @param menuInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = menuDao.updateMenu(menuInfo);
        if (0 == count) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 删除菜单信息
     * @param menuCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode, String userId) {
        List<String> listCode = Arrays.asList(menuCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = menuDao.deleteMenu(listCode, userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }








}
