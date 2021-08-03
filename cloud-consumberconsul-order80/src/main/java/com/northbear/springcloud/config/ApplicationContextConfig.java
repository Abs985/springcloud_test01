package com.northbear.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther northBear
 * @Description
 * @create 2021/7/28 19:31
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //使用负载均衡机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
