package com.driverapp.service;

import com.driverapp.dao.DriverDao;
import com.driverapp.entity.DriverMesInfo;
import com.driverapp.entity.StoreMesInfo;
import org.springframework.stereotype.Service;
import util.AppResponse;

import javax.annotation.Resource;

/**
 * @Description 司机功能类
 * @Author 张鑫
 * @Date 2020-03-27
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * 查询司机详情
     * @param userCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findDriver(String userCode) {
        DriverMesInfo driverMesInfo = driverDao.findDriver(userCode);
        if(null == driverMesInfo){
            return AppResponse.bizError("请检查编号是否为司机编号");
        }
        return AppResponse.success("查询成功！",driverMesInfo);
    }

    /**
     * 查询绑定的门店详情
     * @param storeInviteCode
     * @return
     * @Author 张鑫
     * @Date 2020-3-26
     */
    public AppResponse findStore(String storeInviteCode) {
        StoreMesInfo storeMesInfo = driverDao.findStore(storeInviteCode);
        return AppResponse.success("查询成功！",storeInviteCode);
    }


}
