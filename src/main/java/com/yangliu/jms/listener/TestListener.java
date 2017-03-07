package com.yangliu.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 点评菜品图片上传接口
 */
public class TestListener implements MessageListener{

    final static Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage ms = (ActiveMQTextMessage) message;
        String text;
		try {
			text = ms.getText();
			logger.info(text);
			logger.info(ms.toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}
        
      
 
    }

}

