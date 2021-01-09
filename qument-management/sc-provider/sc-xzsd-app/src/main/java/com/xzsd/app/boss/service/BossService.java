package com.xzsd.app.boss.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.boss.dao.BossDao;
import com.xzsd.app.boss.entity.BossList;
import com.xzsd.app.boss.entity.BossOrder;
import com.xzsd.app.boss.entity.BossUpdate;
import com.xzsd.app.boss.entity.DriverMes;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.OrderList;
import com.xzsd.app.order.entity.OrderSearch;
import com.xzsd.app.order.entity.OrderUpdate;
import com.xzsd.app.personal.dao.PersonalDao;
import com.xzsd.app.personal.entity.LoginMes;
import com.xzsd.app.personal.entity.PersonalInfo;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class BossService {

    @Resource
    private BossDao bossDao;

    @Resource
    private PersonalDao personalDao;

    @Resource
    private OrderDao orderDao;

    /**
     * 查询司机所负责门店信息
     * @param driverMes
     * @return
     */
    public AppResponse findDriverMes(DriverMes driverMes) {
        List<DriverMes> driverInfoList = bossDao.findDriverMes(driverMes);
        return AppResponse.success("查询成功！",driverInfoList);
    }

    /**
     * 查询店长门店订单列表
     * @param bossOrder
     * @Author 张鑫
     * @return
     */
    public AppResponse listBossOrder(BossOrder bossOrder) {
        //获取当前用户编号
        String loginCode = SecurityUtils.getCurrentUserId();
        //存入用户编号
        PersonalInfo personalInfo = new PersonalInfo();
        //对象放用户编号
        personalInfo.setUserCode(loginCode);
        //获取登录信息
        LoginMes loginMes = personalDao.findLoginMes(loginCode);
        //对象存用户角色
        personalInfo.setUserRole(loginMes.getUserRole());
        //获取个人信息
        List<PersonalInfo> personalInfos = personalDao.findRoleMes(personalInfo);
        //存入账号的商品编号
        String a = "";
        for(int i = 0; i < personalInfos.size(); i++){
           a += personalInfos.get(i).getStoreCode() + ",";
        }
        List<String> listCode2 = Arrays.asList(a.split(","));
        bossOrder.setListCode(listCode2);
        List<BossOrder> orderLists = bossDao.listBossOrder(bossOrder);
        return AppResponse.success("查询成功",orderLists);
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @Author 张鑫
     * @return
     */
    public AppResponse findBossOrder(String orderCode) {
        List<BossList>  orderLists = bossDao.findBossOrder(orderCode);
        return AppResponse.success("查询成功",orderLists);
    }

    /**
     * 订单状态修改，
     * @param bossUpdate
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateBossOrderState(BossUpdate bossUpdate) {
        if (bossUpdate.getOrderState() == 2){
            List<OrderSearch> orderSearch = orderDao.findOrder(bossUpdate.getOrderCode());
            int count2 = orderDao.updateInventoryTwo(orderSearch.get(0).getGoodsList());
            System.out.println(orderSearch.get(0).getGoodsList().toString());
        }

        int count = bossDao.updateBossOrderState(bossUpdate);
        if (0 == count) {
            return AppResponse.versionError("修改订单状态失败！");
        }
        return AppResponse.success("修改订单状态成功！");
    }

}
