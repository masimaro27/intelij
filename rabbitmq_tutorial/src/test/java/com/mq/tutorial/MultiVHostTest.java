package com.mq.tutorial;

import com.mq.tutorial.rabbitMQ.EmailMsgSender;
import com.mq.tutorial.rabbitMQ.vo.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MultiVHostTest {
    @Autowired
    private EmailMsgSender emailMsgSender;

    @Test
    public void testMultiVHost() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        emailMsgSender.service("dev-vhost", map);
    }
}
