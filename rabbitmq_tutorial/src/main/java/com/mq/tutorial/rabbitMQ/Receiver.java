package com.mq.tutorial.rabbitMQ;

import com.mq.tutorial.rabbitMQ.vo.Email;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "amq.topic", type = "topic", durable = "true"), //
            key = "test"))
    public void handleMsg1(Email in) {
        System.out.println(0);
        System.out.println(in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "kkaok", durable = "true"),
            exchange = @Exchange(value = "amq.topic", type = "topic", durable = "true"), //
            key = "test.0001"))
    public void handleMsg2(Email in) {
        System.out.println(1);
        System.out.println(in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "push_queue", durable = "true"),
            exchange = @Exchange(value = "push", type = "direct", durable = "true", autoDelete = "true"), //
            key = "test.0002"))
    public void handleMsg3(Map<String,String> in) {
        System.out.println(2);
        System.out.println(in.toString());
    }
}
