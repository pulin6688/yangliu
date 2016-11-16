package com.yangliu.test.wm.to.shop;

import java.util.List;

public class DeliveryRegionTO {
	private String name;
	private List<List<DeliveryRegion>> region;
	private String delivery_time;
	private String delivery_fee;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<List<DeliveryRegion>> getRegion() {
		return region;
	}
	public void setRegion(List<List<DeliveryRegion>> region) {
		this.region = region;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getDelivery_fee() {
		return delivery_fee;
	}
	public void setDelivery_fee(String delivery_fee) {
		this.delivery_fee = delivery_fee;
	}

}
