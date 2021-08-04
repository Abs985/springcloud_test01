package com.northbear.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/3 19:21
 */
@RestController
@RefreshScope // 添加刷新功能，保证和git上的版本变更保持一致
public class ConfigClientController {

    // 此处的config.info是指GitHub上的配置文件中（config-dev.yml ）的属性值
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
