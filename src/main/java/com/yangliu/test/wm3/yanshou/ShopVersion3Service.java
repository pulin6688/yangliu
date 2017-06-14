package com.yangliu.test.wm3.yanshou;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.BaiduAccount;
import com.yangliu.test.wm.utils.BuildDataUtils;
import com.yangliu.test.wm3.CmdV3;
import com.yangliu.test.wm3.entity.ShopClose;
import com.yangliu.test.wm3.entity.ShopCreate;
import com.yangliu.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

/**
 * 百度外卖门店菜品操作 version3
 * @author pul
 *
 */
public class ShopVersion3Service {
	


	private static final String SHOP_CREATE  = "shop.create";
	private static final String SHOP_UPDATE  = "shop.update";
	private static final String SHOP_OPEN    = "shop.open";
	private static final String SHOP_CLOSE   = "shop.close";
	private static final String SHOP_OFFLINE = "shop.offline";
	private static final String SHOP_PIC_UPLOAD = "shop.pic.upload";//商户资质图片上传
	private static final String SHOP_PIC_UPLOAD_NEW = "shop.aptitude.upload";//商户资质图片上传 new




	private static Logger logger =  LoggerFactory.getLogger(ShopVersion3Service.class);


	public static void main(String[] args){
		ShopVersion3Service service = new ShopVersion3Service();

		ShopClose shopClose = new ShopClose();
		shopClose.setShop_id("247900001");
		//service.shopClose(shopClose);
		//service.shopOffline(shopClose);
		service.shopOpen(shopClose);
	}


	public void shopCreate(ShopCreate to){
		logger.info("cmd:{}",SHOP_CREATE);
		try{

		}catch(Exception e){

		}
	}



	//商户歇业
	public void shopClose(ShopClose to){
		logger.info("cmd:{}",SHOP_CLOSE);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(SHOP_CLOSE, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}


	//商户下线
	public void shopOffline(ShopClose to){
		logger.info("cmd:{}",SHOP_OFFLINE);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(SHOP_OFFLINE, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}


	//商户开业
	public void shopOpen(ShopClose to){
		logger.info("cmd:{}",SHOP_OPEN);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(SHOP_OPEN, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}







	
	

}
