package com.yangliu.poipush;

import java.text.SimpleDateFormat;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class Test {
	
	public static SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms"); 
	
	public static void main(String[] args)  throws Exception{
		
		Map<String, Object>  msg = Maps.newHashMap();
		msg.put("brandIdenty", 2479);
		msg.put("shopIdenty", 247900001);
		msg.put("operation", 0);
		
		Map<String, Object>  param = Maps.newHashMap();
		param.put("msg", JSON.toJSONString(msg));
		
		
		String s = HttpUtils.httppost("http://172.18.23.190:9999/api/poipush/m", param);
		System.out.println(s);
	}
}
