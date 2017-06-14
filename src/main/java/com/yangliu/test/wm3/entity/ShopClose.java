package com.yangliu.test.wm3.entity;

import java.io.Serializable;


/*{
    "ticket":"3BDC9E87-2CB1-4B8E-ACA5-FFE75DF02FD3",
    "encrypt":"",
    "sign":"7A2FAE2550A6ACF566E98696800189E7",
    "cmd":"order.cancel",
    "source":"65390",
    "body":"{"order_id":"14906933274710","reason":"POS端发起取消","type":-1}",
    "version":"3",
    "timestamp":"1490693423"
}
*/
public class ShopClose implements Serializable {




	/**
	 * 
	 */

	private static final long serialVersionUID = 4419798517060889038L;
	private String shop_id;
	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
   

}