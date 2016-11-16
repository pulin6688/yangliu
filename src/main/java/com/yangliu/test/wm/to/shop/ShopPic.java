package com.yangliu.test.wm.to.shop;

import java.io.Serializable;

/**
 * 商户资质图片
 * @author pul
 *
 */
public class ShopPic implements Serializable{


    
	private static final long serialVersionUID = -4464249046510856598L;

    private Integer type;
    private String url;
    private String desc;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

   

	
    
}
