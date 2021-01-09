package com.xzsd.app.boss.dao;

import com.xzsd.app.boss.entity.BossList;
import com.xzsd.app.boss.entity.BossOrder;
import com.xzsd.app.boss.entity.BossUpdate;
import com.xzsd.app.boss.entity.DriverMes;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.order.entity.OrderSearch;
import com.xzsd.app.order.entity.OrderUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BossDao {

    /**
     * 查询负责店长商店的司机信息
     * @param driverMes
     * @return
     */
    List<DriverMes> findDriverMes(DriverMes driverMes);

    /**
     * 查询店长商店订单列表
     * @param bossOrder
     * @return
     */
    List<BossOrder> listBossOrder(BossOrder bossOrder);

    /**
     * 查询店长订单详情
     * @param orderCode
     * @return
     */
    List<BossList> findBossOrder(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param bossUpdate
     * @return
     */
    int updateBossOrderState(BossUpdate bossUpdate);




}
