package com.example.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class rabbitTest {
    @RabbitListener(queues = "item_queue")
    public void msg(String msg) throws InterruptedException {

        Thread.sleep(50000);
        System.out.println("消费者消费消息了："+msg);
        //TODO 这里可以做异步的工作
    }
}
