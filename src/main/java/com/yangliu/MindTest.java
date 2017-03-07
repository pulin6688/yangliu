package com.yangliu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.yangliu.utils.HttpUtils;

public class MindTest {
	public static void main(String[] args) throws Exception {
		String url = "http://devpartner.shishike.com/api/core/delivery/bizconfig/get";
		//url = "http://172.16.30.10:9120/api/core/delivery/bizconfig/get";
		     //http://172.16.30.10:9120/api/core/delivery/bizconfig/get
		// 自动配送
		Map<String, Object> param = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		content.put("shopId", 247900001);
		param.put("content", content);
		
		param.put("vender", 99999);
		param.put("platform", "mind");
		param.put("version", "1.0");
		param.put("timestamp", System.currentTimeMillis());
		param.put("sign", UUID.randomUUID().toString().replaceAll("-", ""));

		System.out.println(JSON.toJSONString(param));
		String s = HttpUtils.httppostJson(url, JSON.toJSONString(param));
		System.out.println(s);
	}
}
