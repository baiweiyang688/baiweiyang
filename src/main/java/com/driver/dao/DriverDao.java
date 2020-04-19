package com.driver.dao;

import com.driver.entity.DriverInfo;
import com.goods.entity.GoodsInfo;
import com.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

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




}
