package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;

import java.util.List;

public interface DriverDao {
    /**
     * 查询司机负责门店信息
     * @param driverInfo
     * @return
     */
   List<DriverInfo> findDriver(DriverInfo driverInfo);


}
