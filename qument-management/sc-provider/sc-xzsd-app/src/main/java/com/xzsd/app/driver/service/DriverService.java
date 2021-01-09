package com.xzsd.app.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * 查询司机所负责门店信息
     * @param driverInfo
     * @return
     */
    public AppResponse findDriver(DriverInfo driverInfo) {
         String loginCode = SecurityUtils.getCurrentUserId();
         driverInfo.setUserCode(loginCode);
         List<DriverInfo> driverInfoList = driverDao.findDriver(driverInfo);
        return AppResponse.success("查询成功！",driverInfoList);
    }



}
