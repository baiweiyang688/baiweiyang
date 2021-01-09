package com.customer.service;

import com.alibaba.fastjson.JSON;
import com.customer.dao.CustomerDao;
import com.customer.entity.CustomerInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.GoodsDao;
import com.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import util.AppResponse;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    /**
     * demo 查询客户列表（分页）
     * @param customerInfo
     * @return
     * @Author 张鑫
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfoList = customerDao.listCustomer(customerInfo);
        PageInfo<CustomerInfo> pageData = new PageInfo<CustomerInfo>(customerInfoList);
        return AppResponse.success("查询成功！", pageData);

    }
}
