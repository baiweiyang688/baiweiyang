package com.driver.dao;

import com.driver.entity.DriverMesInfo;
import com.driver.entity.StoreMesInfo;
import com.user.entity.UserInfo;
import com.viewpage.entity.ViewPageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName DriverDao
 * @Description 司机
 * @Author 张鑫
 * @Date 2020-04-10
 */
public interface DriverDao {
    /**
     * 获取司机个人信息
     * @param userCode
     * @return 司机个人信息
     */
    DriverMesInfo findDriver(@Param("userCode") String userCode);

    /**
     * 获取绑定门店信息
     * @param storeInviteCode
     * @return 绑定门店信息
     */
    StoreMesInfo findStore(@Param("storeInviteCode") String storeInviteCode);
}
