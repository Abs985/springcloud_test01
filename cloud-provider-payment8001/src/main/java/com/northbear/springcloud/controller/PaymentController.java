package com.northbear.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.northbear.springcloud.entities.CommonResult;
import com.northbear.springcloud.entities.Payment;
import com.northbear.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @auther northBear
 * @create 16:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentService;

//    服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = {"/payment/create"})
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果" + i + payment);
        if (i > 0) {
            return new CommonResult(200, "数据库插入成功，serverPort"+serverPort, i);
        } else {
            return new CommonResult(444, "数据库插入失败", null);
        }
    }

    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("插入结果" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功，serverPort"+serverPort, paymentById);
        } else {
            return new CommonResult(444, "查询失败，没有查到id为" + id, null);
        }
    }

    @GetMapping(value = {"/discovery"})
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********element"+service);
        }
//        服务发现功能
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMEN-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

//    手写轮询算法
    @GetMapping(value = {"/payment/lb"})
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            // 暂停3秒线程
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
