package rabbitMQ.config;

import rabbitMQ.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RabbitMQConfig {
    static final String topicExchangeName = "spring-boot-exchange";
    static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        return new Queue(queueName, true, false, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    Queue someQueue() {
        return new Queue("someQueue", true);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("amq.topic");
    }

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("fanout.exchg", true, true);
    }

    @Bean
    public FanoutExchange fanout2() {
        return new FanoutExchange("fanout.exchg2", true, true);
    }

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("push",true, true);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy boPolicy = new ExponentialBackOffPolicy();
        boPolicy.setInitialInterval(500);
        boPolicy.setMultiplier(10.0);
        boPolicy.setMaxInterval(10000);
        retryTemplate.setBackOffPolicy(boPolicy);
        rabbitTemplate.setRetryTemplate(retryTemplate);

        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

}
