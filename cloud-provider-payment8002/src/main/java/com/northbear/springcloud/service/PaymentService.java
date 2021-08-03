package com.northbear.springcloud.service;

import com.northbear.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther northBear
 * @create 2021/7/28
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
