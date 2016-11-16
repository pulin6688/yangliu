package com.yangliu.test.wm.to.shop;

import java.io.Serializable;
import java.util.List;

/**
 * 创建商户TO
 * @author pul
 *
 */
public class CreateShopTO implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -4464249046510856598L;
	/**
     * 商户ID,如：10028577
     */
    private Long shop_id;
	private String name;
	private String shop_logo;
	private String province;
	private String city;
	private String county;
	private String address;
	private String brand;
	private String phone;
	private String service_phone;
	private String longitude;
	private String latitude;
	private String coord_type;
	private String book_ahead_time;
	private String invoice_support;
	private String min_order_price;
	private String package_box_price;
	private List<CategorysTO> categorys;
	private List<BusinessTimeTO> business_time;
	private List<DeliveryRegionTO> delivery_region;

	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShop_logo() {
		return shop_logo;
	}
	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCoord_type() {
		return coord_type;
	}
	public void setCoord_type(String coord_type) {
		this.coord_type = coord_type;
	}
	public String getBook_ahead_time() {
		return book_ahead_time;
	}
	public void setBook_ahead_time(String book_ahead_time) {
		this.book_ahead_time = book_ahead_time;
	}
	public String getInvoice_support() {
		return invoice_support;
	}
	public void setInvoice_support(String invoice_support) {
		this.invoice_support = invoice_support;
	}
	public String getMin_order_price() {
		return min_order_price;
	}
	public void setMin_order_price(String min_order_price) {
		this.min_order_price = min_order_price;
	}
	public String getPackage_box_price() {
		return package_box_price;
	}
	public void setPackage_box_price(String package_box_price) {
		this.package_box_price = package_box_price;
	}
	public List<CategorysTO> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<CategorysTO> categorys) {
		this.categorys = categorys;
	}
	public List<BusinessTimeTO> getBusiness_time() {
		return business_time;
	}
	public void setBusiness_time(List<BusinessTimeTO> business_time) {
		this.business_time = business_time;
	}
	public List<DeliveryRegionTO> getDelivery_region() {
		return delivery_region;
	}
	public void setDelivery_region(List<DeliveryRegionTO> delivery_region) {
		this.delivery_region = delivery_region;
	}
	
	
	

   

	
    
}
