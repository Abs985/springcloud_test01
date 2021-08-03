package com.northbear.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/2 11:47
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "--------------PaymentFallbackService fall bcak paymentInfo_Ok,o(╥﹏╥)o-------------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------------PaymentFallbackService fall bcak paymentInfo_TimeOut,o(╥﹏╥)o-------------";
    }
}
