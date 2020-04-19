package com.driver.service;

import com.driver.dao.DriverDao;
import com.driver.entity.DriverInfo;
import com.goods.dao.GoodsDao;
import com.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.AppResponse;
import util.RandomUtil;
import util.StringUtil;

import javax.annotation.Resource;

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
        if(driverInfo.getDriverSex() == null){
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
     * 查询司机商品
     * @param driverCode
     * @return
     * @Author 张鑫
     * @Date 2020-4-19
     */
    public AppResponse findDriver(String driverCode) {
        DriverInfo driverInfo = driverDao.findDriver(driverCode);
        return AppResponse.success("查询成功！", driverInfo);
    }



}
