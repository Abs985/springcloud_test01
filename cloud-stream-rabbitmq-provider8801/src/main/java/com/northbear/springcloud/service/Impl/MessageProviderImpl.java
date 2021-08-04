package com.northbear.springcloud.service.Impl;

import com.northbear.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @auther northBear
 * @Description
 * @create 2021/8/4 16:07
 */

@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;     // 消息发送管道

// https://docs.spring.io/spring-cloud-stream-binder-rabbit/docs/3.1.3/reference/html/spring-cloud-stream-binder-rabbit.html#_partitioning_with_the_rabbitmq_binder
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
//        out.send(MessageBuilder.withPayload(serial).build());
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****************serial"+serial);
        return null;
    }
}
