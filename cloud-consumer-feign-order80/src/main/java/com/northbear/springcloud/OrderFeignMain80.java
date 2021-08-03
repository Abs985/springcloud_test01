package com.northbear.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/1 14:02
 */
@SpringBootApplication
@Slf4j
@EnableFeignClients  // 开启Feign
@EnableEurekaClient // 开启Eureka
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class);
    }
}
