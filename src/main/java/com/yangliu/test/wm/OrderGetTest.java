package com.yangliu.test.wm;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.service.BaiduWaimaiOrderService;
import com.yangliu.test.wm.to.order.OrderCompleteByYanshouTO;

public class OrderGetTest {
	
	private static BaiduWaimaiOrderService baiduWaimaiOrderService = new BaiduWaimaiOrderService();
	
	public static void main(String[] args) throws Exception {
		orderGet();
	}
	
	
	public static void orderGet() throws Exception {
		
		String json = FileUtils.readFileToString(new File("D:/baiduwaimai/orderComplete.txt"), "gbk");
		OrderCompleteByYanshouTO to = JSON.parseObject(json, OrderCompleteByYanshouTO.class);
		baiduWaimaiOrderService.orderGet(to);
	}
	
	
	public static void orderGetV3() throws Exception {
		baiduWaimaiOrderService.orderGetV3(null);
	}

}
