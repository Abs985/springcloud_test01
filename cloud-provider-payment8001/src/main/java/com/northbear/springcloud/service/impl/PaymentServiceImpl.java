package com.northbear.springcloud.service.impl;

import com.northbear.springcloud.dao.PaymentDao;
import com.northbear.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther northBear
 * @create 16:41
 */
@Service
public class PaymentServiceImpl implements PaymentDao{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }

}
