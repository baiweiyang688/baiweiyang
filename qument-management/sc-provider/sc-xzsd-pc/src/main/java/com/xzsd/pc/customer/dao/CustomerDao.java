package com.xzsd.pc.customer.dao;



import com.xzsd.pc.customer.entity.CustomerInfo;

import java.util.List;

public interface CustomerDao {
    /**
     * 获取所有顾客信息
     * @param customerInfo
     * @return
     */
    List<CustomerInfo> listCustomer(CustomerInfo customerInfo);
}
