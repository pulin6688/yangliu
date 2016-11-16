package com.yangliu.test.dianpingqueue;

import java.util.Map;

import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class DianpingQueueTest {
	private static final String IP_DEV = "http://172.16.30.10:9120";
	private static final String IP_TEST = "http://172.16.30.10:9105";
	
	private static final String IP = IP_TEST;
	
	public static void main(String[] args) throws Exception {
		
		create();
	}
	
	
	public static void create() throws Exception {
		String url ="/api/queue/dianping/order/create";
		//url=IP+"/api/queue/dianping/order/create";
		Map<String,Object> data = Maps.newHashMap();
		data.put("content", "111");
		HttpUtils.httppost(url, data);
	}
	
	
}
