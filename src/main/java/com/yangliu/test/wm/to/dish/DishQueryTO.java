package com.yangliu.test.wm.to.dish;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class DishQueryTO implements Serializable{

	private static final long serialVersionUID = 459571502864286770L;
	
    /**
     * 商户ID,如：10028577
     */
    @SerializedName("shop_id")
    private String shopId;
    
    /**
     * 菜品ID,如：12118522
     */
    @SerializedName("dish_id")
    private String dishId;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

    
}
