package com.example.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class yyyy {
    @Bean
    public Queue Queue() {
        return new Queue("hello1");
    }
}
