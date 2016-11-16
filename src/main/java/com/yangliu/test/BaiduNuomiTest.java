package com.yangliu.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.yangliu.utils.HttpUtils;

public class BaiduNuomiTest {
	public static void main(String[] args) throws Exception {
		create();
	}
	
	public static void create() throws Exception {
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/queue.txt"), "gbk");
		String url ="/api/queue/order/create";
		//url=IP+"/api/cater/takeout/baiduwaimai/shop/create";
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}

}
