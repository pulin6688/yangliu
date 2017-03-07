package com.yangliu.jms.producer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Queue;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {
	
	private DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    @Autowired
    @Qualifier("testQueue")
    private Queue testQueue;

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMessage(String message){
    	String date = sdf.format(new Date());
        jmsTemplate.convertAndSend(testQueue,date);
    }
    
    public void sendMessageDelay(String message){
    	String date = sdf.format(new Date());
        jmsTemplate.convertAndSend(testQueue,date,m ->{
        	m.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 60*1000);
        	return m;
        });
    }
}
