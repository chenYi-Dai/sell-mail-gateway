package com.ruoyi.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * MQ消息消费者1
 */
@Component
//监听的队列名称 TestDirectQueue
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiverComsummer {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiverComsummer消费者收到消息  : " + testMessage.toString());
    }

}