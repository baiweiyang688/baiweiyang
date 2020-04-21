package com.driver.dao;

import com.driver.entity.DriverInfo;
import com.driver.entity.DriverList;
import com.goods.entity.GoodsInfo;
import com.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverDao {
    /**
     * 新增司机到用户表
     * @param driverInfo
     * @return
     */
    int addUser(DriverInfo driverInfo);

    /**
     * 新增司机到司机表
     * @param driverInfo
     * @return
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 统计用户账号数量
     * @param driverInfo
     * @return
     */
    int countUserAcct(DriverInfo driverInfo);

    /**
     * 统计用户电话数量
     * @param driverInfo
     * @return
     */
    int countPhone(DriverInfo driverInfo);

    /**
     * 查询司机信息
     * @param driverCode
     * @return 修改结果
     */
    DriverInfo findDriver(@Param("driverCode") String driverCode);

    /**
     * 修改司机表
     * @param driverInfo
     * @return
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 修改用户表
     * @param driverInfo
     * @return
     */
    int updateUser(DriverInfo driverInfo);

    /**
     * 获取所有司机信息
     * @param driverList
     * @return
     */
    List<DriverList> listDriver(DriverList driverList);

    /**
     * 删除司机信息用户表
     * @param listCode 商品信息集合
     * @param userId
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode,@Param("userId") String userId);

    /**
     * 删除司机信息司机表
     * @param listCode 商品信息集合
     * @param userId
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode,@Param("userId") String userId);

}
