package com.northbear.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther northBear
 * @Description 使用feign的日志监控功能
 * @create 2021/8/1 15:11
 */

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
//        表示监控最全的级别
        return Logger.Level.FULL;
    }

}
