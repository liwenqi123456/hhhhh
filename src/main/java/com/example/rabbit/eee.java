package com.example.rabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class eee {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MsgProducer msgProducer;
    @Autowired
    private erer erer;
    @GetMapping("ppp")
    public String  aaa() {
        System.out.println("aaaaa");
        String a="nihao";
        rabbitTemplate.convertAndSend(RabbitConfig.ITEM_TOPIC_EXCHANGE , "item.springboot-rabbitmq" ,a);
        System.out.println("aaaa");
        return "aaaa";
    }
    @GetMapping("/xxx")
    public String EEE(){
        this.erer.send();
        return  "ok";
    }
    @GetMapping("/SSS")
    public String  eee(){

        this.msgProducer.sendMsg("ok");
        return "ok";
    }
}
