package com.yangliu.test.wm.to.shop;

import java.io.Serializable;
import java.util.List;

/**
 * 商户资质图片上传TO
 * @author pul
 *
 */
public class ShopPicUploadNewTO implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -4464249046510856598L;
	/**
     * 商户ID,如：10028577
     */
    private Long shop_id;
    private List<ShopPicNew> pic;
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public List<ShopPicNew> getPic() {
		return pic;
	}
	public void setPic(List<ShopPicNew> pic) {
		this.pic = pic;
	}

	
    
}
