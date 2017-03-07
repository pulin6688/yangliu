package com.yangliu.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.MDC;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.SimpleMessageConverter;

public class SimpleMessageConverterAddMDC extends SimpleMessageConverter {
	  public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
	        Message msg = super.toMessage(object, session);
	        msg.setStringProperty("_global_msg_id", (String) MDC.get("IDENTIFIER"));
	        return msg;
	    }
}
