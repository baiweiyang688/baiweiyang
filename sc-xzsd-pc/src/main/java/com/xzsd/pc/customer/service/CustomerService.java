package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.LoginInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private UserDao userDao;

    /**
     * demo 查询客户列表（分页）
     * @param customerInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        //通过findlogin获取当前登录人的角色role
        String userCode = SecurityUtils.getCurrentUserId();
        LoginInfo userInfoStore = userDao.findLogin(userCode);
        //设置角色
        customerInfo.setUserRole(userInfoStore.getUserRole());
        //设置当前角色编号
        customerInfo.setUserCode(userCode);
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfoList = customerDao.listCustomer(customerInfo);
        PageInfo<CustomerInfo> pageData = new PageInfo<CustomerInfo>(customerInfoList);
        return AppResponse.success("查询成功！", pageData);

    }
}
