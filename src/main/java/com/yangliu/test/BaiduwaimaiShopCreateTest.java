package com.yangliu.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.yangliu.utils.HttpUtils;

public class BaiduwaimaiShopCreateTest {
	private static final String IP_DEV = "http://172.16.30.10:9120";
	private static final String IP_TEST = "http://172.16.30.10:9220";
	
	private static final String IP = IP_TEST;
	
	public static void main(String[] args) throws Exception {
		//createShop();
		//updateShop();
		//openShop();
		//offlineShop();
		//closeShop();
		//picUpload();
		
		
		
		//createDishCategory();
		//updateDishCategory();
		
		
		//createDish();
		//updateDish();
		//deleteDish();
		//showDish();
		
		
		orderConfirm();
		//orderComplete();
		//orderCancel();
		//orderStatusPush();
	}
	
	
	public static void createShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/shop.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/create";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/create";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	public static void updateShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/shop.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/update";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/update";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	public static void openShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/open.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/open";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/open";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void offlineShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/open.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/offline";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/offline";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void closeShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/open.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/close";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/close";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	public static void picUpload() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/picUpload.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/picUpload";
		url=IP+"/api/cater/takeout/baiduwaimai/shop/picUpload";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	//================
	
	public static void createDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishCategory.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/createCategory";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/createCategory";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	public static void updateDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishCategoryUpdate.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/updateCategory";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/updateCategory";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	//================
	
	public static void createDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dish.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/create";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/create";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void updateDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dish.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/update";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/update";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	
	public static void deleteDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishDelete.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/delete";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/delete";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void showDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishShow.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/show";
		url=IP+"/api/cater/takeout/baiduwaimai/dish/show";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void orderConfirm() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/orderConfirm.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/order/confirm";
		url=IP+"/api/cater/takeout/baiduwaimai/order/confirm";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	public static void orderComplete() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/orderComplete.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/order/complete";
		url=IP+"/api/cater/takeout/baiduwaimai/order/complete";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void orderCancel() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/orderCancel.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/order/cancel";
		url=IP+"/api/cater/takeout/baiduwaimai/order/cancel";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void orderStatusPush() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/orderStatusPush.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/order/orderStatusPush";
		url=IP+"/api/cater/takeout/baiduwaimai/order/orderStatusPush";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	
	
	
	

	
	
	

	
	

}
