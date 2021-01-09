package com.menu.controller;

import com.menu.entity.MenuInfo;
import com.menu.entity.MenuListInfo;
import com.menu.service.MenuService;
import com.store.entity.StoreInfo;
import com.viewpage.controller.ViewPageController;
import com.viewpage.service.ViewPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.AppResponse;
import util.AuthUtils;

import javax.annotation.Resource;

/**
 * @Description 菜单管理
 * @Author 张鑫
 * @Date 2020-4-13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    public static final Logger logger =
            LoggerFactory.getLogger(ViewPageController.class);

    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo) {
        try {
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询菜单详情
     * @param menuCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "findMenu")
    public AppResponse findMenu(String menuCode) {
        try {
            return menuService.findMenu(menuCode);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单列表
     * @param menuListInfo
     * @return AppResponse
     * @Author 张鑫
     * @Date 2020-3-26
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu(MenuListInfo menuListInfo) {
        try {
            return menuService.listMenu(menuListInfo);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单信息
     * @param menuInfo
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try {
            //获取修改者id
            String userCode = AuthUtils.getCurrentUserId();
            menuInfo.setCreateBy(userCode);
            menuInfo.setLastModifiedBy(userCode);
            return menuService.updateMenu(menuInfo);
        }catch (Exception e){
            logger.error("修改菜单信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuCode
     * @return AppResponse
     * @author 张鑫
     * @Date 2020-3-26
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try {
            String userId = AuthUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        }catch (Exception e){
            logger.error("删除商品错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
