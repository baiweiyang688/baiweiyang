package com.xzsd.pc.menu.service;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuListInfo;
import com.xzsd.pc.menu.entity.MenuMesInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.LoginInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 菜单实现功能类
 * @Author 张鑫
 * @Date 2020-03-25
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private UserDao userDao;


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
        if(menuCode == null){
            return AppResponse.bizError("请输入菜单编号");
        }
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
        String userCode = SecurityUtils.getCurrentUserId();
        LoginInfo loginInfo = userDao.findLogin(userCode);
        if(loginInfo.getUserRole() == 1){
            List<MenuListInfo> menuListInfoList = menuDao.listMenu(menuListInfo);
            return AppResponse.success("查询成功！", menuListInfoList);
        }
        if(loginInfo.getUserRole() == 2){
            List<MenuListInfo> menuListInfos = new ArrayList<>();
            menuListInfos.add(new MenuListInfo("2020041716134996675","客户管理","/client-manage","客户管理"));
            menuListInfos.add(new MenuListInfo("2020042413464892633","订单管理","/order-manage","订单管理"));
            menuListInfos.add(new MenuListInfo("2020042413472014255","门店信息管理","/shop-info-manage","门店信息管理"));
            menuListInfos.add(new MenuListInfo("2020042413475069009","司机信息管理","/driver-info-manage","司机信息管理"));
            return AppResponse.success("查询成功！", menuListInfos);
        }
       return AppResponse.bizError("当前账号没有权限获取菜单信息！");

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
