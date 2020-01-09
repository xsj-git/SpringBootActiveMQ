package com.lanxin.B2BactiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    private int i;

    @Scheduled(fixedDelay = 1)//3000=3s执行一次
    public void send() {
        i = i+1;
        System.out.println(i+"条数据");
        jmsMessagingTemplate.convertAndSend(queue, "holle word Queue1  "+i);
        jmsMessagingTemplate.convertAndSend(topic, "holle word Topic1  "+i);

    }

    @Scheduled(fixedDelay = 1)//3000=3s执行一次
    public void send1() {
        i = i+1;
        System.out.println(i+"条数据");
        jmsMessagingTemplate.convertAndSend(queue, "holle word Queue2  "+i);
        jmsMessagingTemplate.convertAndSend(topic, "holle word Topic2  "+i);

    }


}
