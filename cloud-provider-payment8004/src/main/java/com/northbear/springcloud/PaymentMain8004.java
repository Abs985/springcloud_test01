package com.northbear.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther northBear
 * @Description
 * @create 2021/7/30 9:21
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解使用与使用zookeeper或者consul作为注册中心使用时
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class);
    }

}
