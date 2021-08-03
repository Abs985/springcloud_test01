package com.northbear.springcloud.controller;

import com.northbear.springcloud.entities.CommonResult;
import com.northbear.springcloud.entities.Payment;
import com.northbear.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther northBear
 * @create 16:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = {"/payment/create"})
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入结果"+i+payment);
        if (i>0){
            return new CommonResult(200,"数据库插入成功，serverPort"+serverPort,i);
        }else{
            return new CommonResult(444,"数据库插入失败",null);
        }
    }

    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("插入结果"+paymentById);
        if (paymentById!=null){
            return new CommonResult(200,"查询成功，serverPort"+serverPort,paymentById);
        }else{
            return new CommonResult(444,"查询失败，没有查到id为"+id,null);
        }
    }

    //    手写轮询算法
    @GetMapping(value = {"/payment/lb"})
    public String getPaymentLB(){
        return serverPort;
    }
}
