package com.yangliu.test.wm.to.dish;

/**
 * 创建菜品分类TO
 * @author pul
 *
 */
public class CreateDishCategoryTO {
	
	private String shop_id; //	是		合作方商户唯一 ID
	
	private String name;	//	是		分类名称
	
	private String  old_name; //原分类名称 修改菜品分类的时候用
	
	private String rank;	//  否		降序排序，大于0
	
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getOld_name() {
		return old_name;
	}
	public void setOld_name(String old_name) {
		this.old_name = old_name;
	}
	


}
