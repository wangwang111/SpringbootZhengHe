package com.wang.springboot.rabbitmq.controller;

import com.wang.rabbitmq.bean.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendList")
    public String sendMessageObject() {
        for (int i = 0; i < 10000; i++) {
            Person person = new Person(i, "wang");
            rabbitTemplate.convertAndSend(
                    "hello-java-exchange",
                    "hello.java",
                    person);
        }
        return "success";
    }

    @GetMapping("/string")
    public String sendMessageTest() {
        rabbitTemplate.convertAndSend(
                "hello-java-exchange",
                "hello.java",
                "hello world");
        return "success";
    }

}
