package com.yangliu;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class HttpUtilsTest {
	
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:9999/test/d";
		Map<String, Object> data = Maps.newHashMap();
		data.put("cmd", "cmd");
		data.put("version", "3");
		data.put("body", "{\"order_id\":\"123\"}");
		//HttpUtils.httppost(url, data);
		
		String json = FileUtils.readFileToString(new File("D://baiduwaimai/test/create.txt"),"gbk");
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main() throws Exception {
		//String url = "http://localhost:8080/index/test";
		String url = "http://devpartner.shishike.com/api/core/bizAuth/saveOrUpdate";
		
		/*Map<String, Object> param = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		content.put("shopId", 247900001);
		param.put("content", content);
		
		param.put("vender", 99999);
		param.put("platform", "test");
		param.put("version", "1.0");
		param.put("timestamp", System.currentTimeMillis());
		param.put("sign", UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println(JSON.toJSONString(param));*/
		
		String json = FileUtils.readFileToString(new File("D://pulin/aaa.txt"),"gbk");
		
		//url = "http://testpartner.shishike.com/api/core/delivery/bizconfig/update";
		//json = FileUtils.readFileToString(new File("D://pulin/bbb.txt"),"gbk");
		
		String s = HttpUtils.httppostJson(url, json);
		System.out.println(s);
	}
}
