package com.yangliu.test.wm.to.dish;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

/**
 * 菜品可售时间段
 * @author pul
 *
 */
public class DishAvailableTimeTO {
	
	@SerializedName("*")
	@JSONField(name="*")
	private List<DishAvailableTime> day;
	
	@SerializedName("1")
	@JSONField(name="1")
	private List<DishAvailableTime> day1;
	
	@SerializedName("2")
	@JSONField(name="2")
	private List<DishAvailableTime> day2;
	
	@SerializedName("3")
	@JSONField(name="3")
	private List<DishAvailableTime> day3;
	
	@SerializedName("4")
	@JSONField(name="4")
	private List<DishAvailableTime> day4;
	
	@SerializedName("5")
	@JSONField(name="5")
	private List<DishAvailableTime> day5;
	
	@SerializedName("6")
	@JSONField(name="6")
	private List<DishAvailableTime> day6;
	
	@SerializedName("7")
	@JSONField(name="7")
	private List<DishAvailableTime> day7;
	
	public List<DishAvailableTime> getDay() {
		return day;
	}
	public void setDay(List<DishAvailableTime> day) {
		this.day = day;
	}
	public List<DishAvailableTime> getDay1() {
		return day1;
	}
	public void setDay1(List<DishAvailableTime> day1) {
		this.day1 = day1;
	}
	public List<DishAvailableTime> getDay2() {
		return day2;
	}
	public void setDay2(List<DishAvailableTime> day2) {
		this.day2 = day2;
	}
	public List<DishAvailableTime> getDay3() {
		return day3;
	}
	public void setDay3(List<DishAvailableTime> day3) {
		this.day3 = day3;
	}
	public List<DishAvailableTime> getDay4() {
		return day4;
	}
	public void setDay4(List<DishAvailableTime> day4) {
		this.day4 = day4;
	}
	public List<DishAvailableTime> getDay5() {
		return day5;
	}
	public void setDay5(List<DishAvailableTime> day5) {
		this.day5 = day5;
	}
	public List<DishAvailableTime> getDay6() {
		return day6;
	}
	public void setDay6(List<DishAvailableTime> day6) {
		this.day6 = day6;
	}
	public List<DishAvailableTime> getDay7() {
		return day7;
	}
	public void setDay7(List<DishAvailableTime> day7) {
		this.day7 = day7;
	}
	
	

}
