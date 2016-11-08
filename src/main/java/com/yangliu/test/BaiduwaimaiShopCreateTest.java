package com.yangliu.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.yangliu.utils.HttpUtils;

public class BaiduwaimaiShopCreateTest {
	
	public static void main(String[] args) throws Exception {
		//createShop();
		//openShop();
		//closeShop();
		
		//createDishCategory();
		//updateDishCategory();
		
		
		createDish();
		//deleteDish();
		//showDish();
	}
	
	
	public static void createShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/shop.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/create";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/shop/create";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	public static void openShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/open.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/open";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/shop/open";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void closeShop() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/open.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/shop/close";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/shop/close";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	
	
	public static void createDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishCategory.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/createCategory";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/dish/createCategory";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	public static void updateDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishCategoryUpdate.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/updateCategory";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/dish/updateCategory";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	
	
	public static void createDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dish.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/create";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/dish/create";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void deleteDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishDelete.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/delete";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/dish/delete";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	public static void showDish() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/dishShow.txt"), "gbk");
		String url ="http://devpartner.shishike.com/api/cater/takeout/baiduwaimai/dish/show";
		url="http://172.16.30.10:9120/api/cater/takeout/baiduwaimai/dish/show";
		String s = HttpUtils.httppostJson(url, json);
		//System.out.println(s);
	}
	
	
	

	
	

}
