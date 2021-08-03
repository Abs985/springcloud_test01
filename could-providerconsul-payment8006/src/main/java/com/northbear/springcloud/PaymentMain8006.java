package com.northbear.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther northBear
 * @Description
 * @create 2021/7/31 16:14
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class);
    }
}
