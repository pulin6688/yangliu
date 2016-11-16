package com.yangliu.test.wm.to.dish;

/**
 * 菜品分类
 * @author pul
 *
 */
public class DishCategoryTO {
	
	private String name;//分类名称
	
	private int rank;//在分类中排序
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
