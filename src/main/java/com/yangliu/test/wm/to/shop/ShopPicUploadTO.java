package com.yangliu.test.wm.to.shop;

import java.io.Serializable;
import java.util.List;

/**
 * 商户资质图片上传TO
 * @author pul
 *
 */
public class ShopPicUploadTO implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -4464249046510856598L;
	/**
     * 商户ID,如：10028577
     */
    private Long shop_id;
//  shop_id	string	是	合作方商户唯一 ID
    private List<ShopPic> pic;
//    pic	array	是	商户资质图片
//    pic.{i} .type	int	是	图片类型，参见附录商户资质图片类型对照表
//    pic.{i}.url	string	是	图片地址
//    pic.{i}.desc	string	是	备注
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public List<ShopPic> getPic() {
		return pic;
	}
	public void setPic(List<ShopPic> pic) {
		this.pic = pic;
	}

   

	
    
}
