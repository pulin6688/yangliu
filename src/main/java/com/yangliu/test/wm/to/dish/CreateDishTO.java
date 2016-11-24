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
	private Integer stock;//	int	否		菜品每日库存，每日0点恢复库存
	private List<DishCategoryTO> category;
	private List<DishAttrTO> attr;

	
	
	

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
