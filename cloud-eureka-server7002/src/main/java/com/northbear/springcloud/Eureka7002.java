package com.northbear.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther northBear
 * @Description
 * @create 2021/7/29 11:12
 */
@SpringBootApplication
@EnableEurekaServer //集群设置，服务端
public class Eureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002.class);
    }
}
