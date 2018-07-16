package com.netease.zengchen.component;

import com.netease.zengchen.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author zengchen
 * @Date 2018/7/16 19:09
 * @Version 1.0
 **/

@Component
public class Consumer {
    @RabbitListener(queues=RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(String message){
        System.out.println("consume:"+"[" + message + "]");
    }

}
