package com.netease.zengchen.controller;

import com.netease.zengchen.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.time.DateTimeException;
import java.util.Date;

/**
 * @ClassName ProducerController
 * @Description TODO
 * @Author zengchen
 * @Date 2018/7/16 17:13
 * @Version 1.0
 **/
@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMessage")
    public Object sendMessage(){
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String value = new Date().toString();
                System.out.println(value);
                rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, value);
            }
        }).start();
        return "ok";
    }

}
