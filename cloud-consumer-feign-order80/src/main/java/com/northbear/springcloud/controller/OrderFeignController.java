package com.northbear.springcloud.controller;

import com.northbear.springcloud.entities.CommonResult;
import com.northbear.springcloud.entities.Payment;
import com.northbear.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/1 14:12
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = {"/consumer/payment/get/{id}"})
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

//    模拟超时调用，通过客户端调用服务端模块的功能超时相应
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
