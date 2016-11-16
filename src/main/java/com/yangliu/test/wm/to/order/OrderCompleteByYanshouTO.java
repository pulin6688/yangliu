package com.yangliu.test.wm.to.order;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;


public class OrderCompleteByYanshouTO implements Serializable {

	
	private static final long serialVersionUID = 1563239480243742386L;

	@SerializedName("order_id")
	@JSONField(name="order_id")
	private String order_id;
	
	@SerializedName("shop_id")
	@JSONField(name="shop_id")
	private Long shop_id;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	
	


	
	
}
