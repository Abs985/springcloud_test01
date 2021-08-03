package com.northbear.springcloud.service;

import com.northbear.springcloud.entities.CommonResult;
import com.northbear.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/1 14:06
 */
@Component
@FeignClient(value = "cloud-payment-service") // 使用：指定调用模块名称
public interface PaymentFeignService {

    //    写调用模块名相同的方法名，完全复制过来即可
    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
