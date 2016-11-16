package com.yangliu.test.wm.to.shop;

import java.io.Serializable;

/**
 * 修改商户状态TO 对应的是商户开业shop.open 商户歇业shop.close 商户下线shop.offline
 * @author pul
 *
 */
public class ModifyShopStatusTO implements Serializable{

	private static final long serialVersionUID = -3732470597360196024L;
	
	/**
     * 商户ID,如：10028577
     */
    private Long shop_id;

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
    

    
}
