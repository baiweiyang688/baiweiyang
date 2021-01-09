package com.driver.service;

import com.alibaba.fastjson.JSON;
import com.driver.dao.DriverDao;
import com.driver.entity.DriverInfo;
import com.driver.entity.DriverList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.GoodsDao;
import com.goods.entity.GoodsInfo;
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
public class DriverService {

    //映射资源
    @Resource
    private DriverDao driverDao;

    /**
     * 新增司机到用户表和司机表
     * @param driverInfo
     * @Author 张鑫
     * @Date 2020-4-19
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo) {
        //检验商品名称是否重复
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (countUserAcct != 0) {
            return AppResponse.bizError("用户名称已存在，请重新输入");
        }
        int countPhone = driverDao.countPhone(driverInfo);
        if (countPhone != 0) {
            return AppResponse.bizError("用户电话已使用，请重新输入");
        }
        //随机编号
        if(driverInfo.getDriverSex() == null || "".equals(driverInfo.getDriverSex())){
            driverInfo.setDriverSex("1");
        }
//        driverInfo.setDriverPassword(PasswordUtils.generatePassword(driverInfo.getDriverPassword()));
        driverInfo.setDriverCode(RandomUtil.randomDriverCode());
        driverInfo.setIsDeleted(0);
        int countUser = driverDao.addUser(driverInfo);
        int countDriver = driverDao.addDriver(driverInfo);
        if (countUser == 0 || countDriver == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询司机信息
     * @param driverCode
     * @return
     * @Author 张鑫
     * @Date 2020-4-19
     */
    public AppResponse findDriver(String driverCode) {
        DriverInfo driverInfo = driverDao.findDriver(driverCode);
        return AppResponse.success("查询成功！", driverInfo);
    }


    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     * @Author 张鑫
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (countUserAcct != 0) {
            return AppResponse.bizError("用户账号已存在，请重新修改");
        }
        int countPhone = driverDao.countPhone(driverInfo);
        if (countPhone != 0) {
            return AppResponse.bizError("用户电话已使用，请重新修改");
        }
        //这里调用了数据库修改 数据库里version是条件，veision没有对应上则会弹出这句话，被其他人修改了
        int count = driverDao.updateDriver(driverInfo);
        int count2 = driverDao.updateUser(driverInfo);
        if (0 == count || 0 == count2) {
            return AppResponse.success("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * demo 查询司机列表（分页）
     * @param driverList
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverList driverList) {
        PageHelper.startPage(driverList.getPageNum(), driverList.getPageSize());
        List<DriverList> driverLists = driverDao.listDriver(driverList);
        PageInfo<DriverList> pageData = new PageInfo<DriverList>(driverLists);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * demo 删除司机信息
     * @param driverCode
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverCode, String userId) {
        List<String> listCode = Arrays.asList(driverCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = driverDao.deleteDriver(listCode, userId);
        int count2 = driverDao.deleteUser(listCode, userId);
        if (0 == count || 0 == count2) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }



}
