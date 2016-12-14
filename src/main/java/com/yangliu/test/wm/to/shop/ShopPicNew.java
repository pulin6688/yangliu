package com.yangliu.test.wm.to.shop;

import java.io.Serializable;

/**
 * 商户资质图片
 * @author pul
 *
 */
public class ShopPicNew implements Serializable{


    
	private static final long serialVersionUID = -4464249046510856598L;

    private Integer type;//资质类型（类型对照表见附录）
    private String url;//图片地址
    private String water_url;//水印地址
    private String desc;//备注
    private String license_name;//否                      证件名称（type为：1,8,14,15,16时必传）
    private String license_number;//否                 证件编号（type为：1,8,14,15,16时必传）
    private String license_validitytime;//否  证件有效期（type为：1,8,14,15,16时必传）（例如：2017-01-01）
    private String registration_number;//否   税务登记证编号
    private String organization_number;//否   组织机构代码证编号
    private String permission_number;//否         许可证编号
    private String permission_time;//否               许可证有效期（例如：2017-01-01）
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
	public String getWater_url() {
		return water_url;
	}
	public void setWater_url(String water_url) {
		this.water_url = water_url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLicense_name() {
		return license_name;
	}
	public void setLicense_name(String license_name) {
		this.license_name = license_name;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public String getLicense_validitytime() {
		return license_validitytime;
	}
	public void setLicense_validitytime(String license_validitytime) {
		this.license_validitytime = license_validitytime;
	}
	public String getRegistration_number() {
		return registration_number;
	}
	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}
	public String getOrganization_number() {
		return organization_number;
	}
	public void setOrganization_number(String organization_number) {
		this.organization_number = organization_number;
	}
	public String getPermission_number() {
		return permission_number;
	}
	public void setPermission_number(String permission_number) {
		this.permission_number = permission_number;
	}
	public String getPermission_time() {
		return permission_time;
	}
	public void setPermission_time(String permission_time) {
		this.permission_time = permission_time;
	}
    
}
