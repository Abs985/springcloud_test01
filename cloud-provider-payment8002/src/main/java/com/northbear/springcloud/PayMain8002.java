package com.northbear.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @auther northBear
 * @Description
 * @create 2021/7/29 11:47
 */


@SpringBootApplication
@EnableEurekaClient
public class PayMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain8002.class, args);

    }
}