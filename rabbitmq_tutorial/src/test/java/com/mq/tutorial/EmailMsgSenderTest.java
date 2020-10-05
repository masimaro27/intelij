package com.mq.tutorial;

import com.mq.tutorial.rabbitMQ.EmailMsgSender;
import com.mq.tutorial.rabbitMQ.vo.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmailMsgSenderTest {
    @Autowired
    private EmailMsgSender emailMsgSender;

    @Test
    public void testSendMsg() {
        Email email = new Email("info@example.com", "Hello");
        emailMsgSender.sendEmail("test.0001", email);
    }
}
