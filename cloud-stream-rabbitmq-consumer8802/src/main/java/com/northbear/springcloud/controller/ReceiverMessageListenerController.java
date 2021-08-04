package com.northbear.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/4 17:30
 */
@Component
@EnableBinding(Sink.class)
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，---------------》收到的消息"+message.getPayload()+"\t  port"+serverPort);

    }

}
