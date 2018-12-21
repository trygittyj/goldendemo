package com.example.demo.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.impl.AMQImpl.Queue;
//import com.rabbitmq.client.AMQP.Queue;
//import org.springframework.amqp.core.Queue;




@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello",true);
    }

}