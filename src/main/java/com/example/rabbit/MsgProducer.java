package com.example.rabbit;



import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.UUID;
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private RabbitTemplate rabbitTemplate;
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate=rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);

    }
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回调"+correlationData);
        if(b){
            System.out.println("FASSSSS");
        }else{
            System.out.println("fffff");
        }
    }
    public void sendMsg(String msg){
        CorrelationData correlationData=new CorrelationData((UUID.randomUUID().toString()));
        rabbitTemplate.convertAndSend(RabbitConfig.ITEM_TOPIC_EXCHANGE , "item.springboot-rabbitmq" ,"OK",correlationData);
    }
}
