package com.yangliu.test.wm3;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import com.facebook.presto.jdbc.internal.guava.collect.Maps;

public class SignTest {
	

	
	
	

	

	
	
	public static void main(String[] args) throws Exception {
		
		   Double statusDouble = Double.parseDouble("5");
           Integer status = null;
          if(status==5){}
		
		String bodys = FileUtils.readFileToString(new File("D://body2.txt"), "utf-8");
		//request();
		//response();
	}
	
	
	
//	{
//    "cmd":"resp.order.create",
//    "timestamp":1490597763,
//    "version":"3",
//    "ticket":"A15AFF4B-CD3D-40AF-A112-D5D38C28AB25",
//    "source":"65390",
//    "sign":"25281D0529C409678D2F348548C8CBC0",
//    "body":{
//        "errno":0,
//        "error":"success",
//        "data":{
//            "source_order_id":"58d8b77e35baee8cdf00d974"
//        }
//    }
//}
	//响应参数计算sign
	public static void response() throws Exception {
		TreeMap<String, Object> requestMap = Maps.newTreeMap();
		requestMap.put("cmd", "resp.order.create");
		requestMap.put("timestamp", 1490600762);
		requestMap.put("version", "3");
		requestMap.put("ticket", "1FA2B306-0B50-49E2-BE6B-A6E9C01C09E6");
		requestMap.put("source", "65390");
		requestMap.put("secret", "6f48db35eef9c822");
		//requestMap.put("sign", "25281D0529C409678D2F348548C8CBC0");
		requestMap.put("encrypt", "");
		
//		TreeMap<String, Object> body = Maps.newTreeMap();
//		body.put("errno", 0);
//		body.put("error", "success");
//		TreeMap<String, Object> data = Maps.newTreeMap();
//		data.put("source_order_id", "58d8b77e35baee8cdf00d974");
//		body.put("data", data);
//		requestMap.put("body", body);
		
		String bodys = FileUtils.readFileToString(new File("D://body2.txt"), "utf-8");
		requestMap.put("body", bodys);
		CmdV3.getSign(requestMap);
	}
	
	
//	{
//    "cmd":"order.create",
//    "timestamp":1490597763,
//    "version":"3",
//    "ticket":"F144B276-F465-D04E-06DF-CF9C3CDB66C7",
//    "source":"65390",
//    "body":{
//        "order_id":"14905977553713"
//    },
//    "sign":"13A548010A505C80313760F58B7F3950",
//    "encrypt":""
//}
//
	//请求参数计算sign
	public static void request() {
		TreeMap<String, Object> requestMap = Maps.newTreeMap();
		requestMap.put("cmd", "order.create");
		requestMap.put("timestamp", "1490597763");
		requestMap.put("version", "3");
		requestMap.put("ticket", "F144B276-F465-D04E-06DF-CF9C3CDB66C7");
		requestMap.put("source", "65390");
		requestMap.put("secret", "6f48db35eef9c822");
		requestMap.put("encrypt", "");
		TreeMap<String, Object> body = Maps.newTreeMap();
		body.put("order_id", "14905977553713");
		requestMap.put("body", body);
		CmdV3.getSign(requestMap);
	}

}
