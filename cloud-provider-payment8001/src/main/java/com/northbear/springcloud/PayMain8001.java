package com.northbear.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  // 发现服务开启
public class PayMain8001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PayMain8001.class, args);

    }
}
