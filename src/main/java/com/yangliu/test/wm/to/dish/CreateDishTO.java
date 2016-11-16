package com.yangliu.test.wm.to.dish;

import java.util.List;

public class CreateDishTO {
	
	private String shop_id; //	是		合作方商户唯一 ID
	private String dish_id; //	是		菜品唯一编号
	private String name;	//	是		菜品名称
	private String upc;	    //  否		条形码编号
	private Integer    price;	//  是		菜品价格，单位：分
	private String pic;	    //	否		菜品图片，小于3M，尺寸大于等于640*640px
	private Integer    min_order_num;	  //是		最小起订份数
	private Integer    package_box_num;	  //是		单份所需餐盒数
	private String description;	     //  否		描述
	
	
	private DishAvailableTimeTO available_times;//可售时间
//	available_times;	array	否	同营业时间	可售时间“i”为 1 表示周一，为 7 表示周日
//	available_times.{i}.{j}.start	string	否		开始时间
//	available_times.{i}.{j}.end	string	否		结束时间
	
	private Integer stock;//	int	否		菜品每日库存，每日0点恢复库存
	
	//threshold(已废弃)	array	否		请使用stock字段。如果继续传入threshold字段，系统将取threshold的第一个值，当做菜品的全天库存量。菜品库存设置，参见说明
	//threshold.{i}.num	int	是		初始化值
	//threshold.{i}.time	string	是		初始化时间
	
	private List<DishCategoryTO> category;
	//category	array	是		分类信息
	//category.{i}.name	string	是		分类名称
	//category.{i}.rank	int	否		在分类中排序
	
//	norms(弃用)	array	否		菜品规格
//	norms.{i}.name	string	否		规格名称
//	norms.{i}. value	string	是		规格名称值
//	norms.{i}.price	int	是		价格，单位：分
//	norms.{i}.threshold	array	否		菜品库存设置
//	norms.{i}.threshold.{i}.num	int	是		初始化值
//	norms.{i}.threshold.{i}.time	string	是		初始化时间
	
	
	private List<DishAttrTO> attr;
//	attr	array	否		菜品属性
//	attr .{i}.name	string	是		属性名称
//	attr.{i}. value	string	是		属性值
	
	
	

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getDish_id() {
		return dish_id;
	}

	public void setDish_id(String dish_id) {
		this.dish_id = dish_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getMin_order_num() {
		return min_order_num;
	}

	public void setMin_order_num(Integer min_order_num) {
		this.min_order_num = min_order_num;
	}

	public Integer getPackage_box_num() {
		return package_box_num;
	}

	public void setPackage_box_num(Integer package_box_num) {
		this.package_box_num = package_box_num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DishAvailableTimeTO getAvailable_times() {
		return available_times;
	}

	public void setAvailable_times(DishAvailableTimeTO available_times) {
		this.available_times = available_times;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DishCategoryTO> getCategory() {
		return category;
	}

	public void setCategory(List<DishCategoryTO> category) {
		this.category = category;
	}

	public List<DishAttrTO> getAttr() {
		return attr;
	}

	public void setAttr(List<DishAttrTO> attr) {
		this.attr = attr;
	}
	

}
