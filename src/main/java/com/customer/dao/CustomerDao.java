package com.customer.dao;

import com.customer.entity.CustomerInfo;
import com.goods.entity.GoodsInfo;

import java.util.List;

public interface CustomerDao {
    /**
     * 获取所有顾客信息
     * @param customerInfo
     * @return
     */
    List<CustomerInfo> listCustomer(CustomerInfo customerInfo);
}
