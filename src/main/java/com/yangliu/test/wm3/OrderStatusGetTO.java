package com.yangliu.test.wm3;

import java.io.Serializable;



public class OrderStatusGetTO implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 4419798517060889038L;
	private String order_id;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
   

}