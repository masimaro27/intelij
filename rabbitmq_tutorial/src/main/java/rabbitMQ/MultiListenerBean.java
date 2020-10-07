package rabbitMQ;

import rabbitMQ.vo.Cat;
import rabbitMQ.vo.Hat;
import rabbitMQ.vo.Thing2;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@RabbitListener(id="multi", queues = "someQueue")
@SendTo("my.reply.queue")
public class MultiListenerBean {

    @RabbitHandler
    public String thing2(Thing2 thing2) {
        System.out.println("Thing2 : " + thing2.toString());
        return thing2.toString();
    }

    @RabbitHandler
    public String cat(Cat cat) {
        System.out.println("cat : " + cat.toString());
        return cat.toString();
    }

    @RabbitHandler
    public String hat(@Header("amqp_receivedRoutingKey") String rk, @Payload Hat hat) {
        System.out.println("hat : " + hat.toString());
        return hat.toString();
    }

    @RabbitHandler(isDefault = true)
    public String defaultMethod(Object object) {
        System.out.println("default" + object.toString() );
        return "default";
    }
}
