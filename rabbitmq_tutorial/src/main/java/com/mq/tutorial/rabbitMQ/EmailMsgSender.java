package com.mq.tutorial.rabbitMQ;

import com.mq.tutorial.rabbitMQ.vo.Email;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.SimpleResourceHolder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailMsgSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topic;

    @Autowired
    private DirectExchange directExchange;

    public void sendEmail(String routingKey, Email email){
        rabbitTemplate.convertAndSend(topic.getName(), routingKey, email);
    }

    public void service(String vHost, Map<String,String> payload) {
        SimpleResourceHolder.bind(rabbitTemplate.getConnectionFactory(), vHost);
        rabbitTemplate.convertAndSend(directExchange.getName(),"test.0002", payload);
        SimpleResourceHolder.unbind(rabbitTemplate.getConnectionFactory());
    }
}
