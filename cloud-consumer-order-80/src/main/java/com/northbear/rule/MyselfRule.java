package com.northbear.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther northBear
 * @Description 使用自定义轮询规则是不能被componentScan所扫描到
 * @create 2021/7/31 16:57
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();//返回随机轮询规则
    }
}
