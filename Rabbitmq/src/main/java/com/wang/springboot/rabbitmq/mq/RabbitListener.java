package com.wang.springboot.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.wang.springboot.rabbitmq.bean.Person;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener {

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "message.queue")
    public void receiveTTlMessageMQ(Message message) {
        System.out.println("message死信队列接受到消息..." + message);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "dlx.queue")
    public void receiveTTlMessage(Message message) {
        System.out.println("死信队列接受到消息..." + message);
    }


    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "hello-java-queue")
    public void receiveMessage(Message message,
                               Person person,
                               Channel channel) {
        System.out.println("接受到消息..." + message);
        System.out.println("内容..." + person);

        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            // 收货
//            channel.basicAck(deliveryTag, false);

            // 退货
//            channel.basicNack(deliveryTag, false, true);
        } catch (Exception e) {

        }
    }
}
