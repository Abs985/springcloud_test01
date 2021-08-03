package com.northbear.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/1 16:16
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池  " + Thread.currentThread().getName() + "\t paymentInfo_Ok,id" + id;
    }

    /**
     * 访问失败
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //指定下方代码运行超过3秒时，执行fallback，只要下方程序出现错误就执行指定的报错方法 paymentInfo_TimeOutHandler
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }) // 下方代码出问题，指定fallbackMethod方法兜底
    public String paymentInfo_TimeOut(Integer id) {
//        int a=10/0;// 也是执行指定的报错方法
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池  " + Thread.currentThread().getName() + "\t paymentInfo_TimeOut,id" + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池  " + Thread.currentThread().getName() + "\t 系统繁忙或出错,兜底的方法,id" + id;

    }

    //==========================服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
            // 在固定时间窗口期内，达到指定请求次数，且失败率在指定（60）后开始跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功,流水号" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试o(╥﹏╥)o" + id;
    }

}
