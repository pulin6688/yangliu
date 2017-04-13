package com.yangliu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class HttpUtilsTest {
	
	public static SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms"); 
	
	public static void main(String[] args)  throws Exception{

//		String clientId = "testid";
//		String clientSecret = "testSer";
//		String scope = "testscope";
//		String username = "15912345678";
//		String password = "1qaz2wsx";
//		String url = "https://openapi-p.4008827123.cn/oauth/token";
//		Map<String, Object> param = Maps.newHashMap();
//		param.put("client_id", clientId);
//		param.put("client_secret", clientSecret);
//		param.put("grant_type", "password");
//		param.put("scope", scope);
//		param.put("username", username);
//		param.put("password", password);
//		String s = HttpUtils.httppost(url, param);
//		System.out.println(s);
//		
		
		
		
//		
//		client_id	String(64)	是	第三方开发者APPID
//		client_secret	String(64)	是	第三方开发者密钥
//		response_type	String(64)	是	校验模式，固定值code
//		scope	String(64)	是	权限范围
		
//		thirdparty_merchant_no	String(64)	是	接入系统商家编号
//		thirdparty_merchant_name	String(64)	是	接口系统商家名称
		
//		thirdparty_store_no	String(64)	是	接入系统门店编号
//		thirdparty_store_name	String(64)	是	接口系统门店名称
		
		
		
		
//		https://openapi-p.4008827123.cn
//			clientId:keruyun
//			clientSecret:f845a0e4d8df480c9a809c46f43ddb3e
//			grantType=password
//			scope=common_scope
//			userName=25011111111
//			password=abc123
		
		Map<String, Object>  param = Maps.newHashMap();
		param.put("client_id", "keruyun");
		param.put("client_secret", "f845a0e4d8df480c9a809c46f43ddb3e");
		
		param.put("response_type", "code");
		//param.put("grant_type", "code");
		
		param.put("scope", "common_scope");
		
		param.put("thirdparty_merchant_no", "S1111111111");
		param.put("thirdparty_merchant_name", "A1111111111");
		
		param.put("thirdparty_store_no", "S1111111111");
		param.put("thirdparty_store_name", "A1111111111");
		
	
		
		String s = HttpUtils.httppost("https://openapi-p.4008827123.cn/oauth/authorize", param);
		System.out.println(s);
	}
	
	
	
	
	
	
	public static void main2(String[] args) throws Exception {
		
	
		
		
//		String a="\"123\"";
//		System.out.println(a.replace("\"",""));
//		
//		System.out.println(a.replace("^[0-9]",""));
		
	/*	String url = "http://testpartner.shishike.com/api/cater/takeout/baiduwaimai";
		Map<String, Object> data = Maps.newHashMap();
		data.put("cmd", "order.status.push");
		data.put("timestamp", "1490671302");
		data.put("source", "65390");
		data.put("ticket", "E2C480F6-3D21-D438-CB26-1F7C79282E4F");
		data.put("sign", "9D84F1E73D2F605875A2399976B527F4");
		data.put("encrypt", "");
		data.put("version", "3");
		data.put("body", "{\"order_id\":\"14906920489287\",\"status\":10}");
		String s = HttpUtils.httppost(url, data);
		System.out.println(s);*/
		
		for(int i=1;i<=1;i++){
			
	/*		new Thread(new Runnable(){
				public void run() {
					while(true){
						try {
							String url = "http://localhost:7777/redis/get";
							Map<String, Object> data = Maps.newHashMap();
							String s = HttpUtils.httppost(url, data);
							System.out.println("7777|"+s);
							Integer d = (int) (1000+Math.random()*1000);
							Thread.sleep(Long.parseLong(d.toString()));
						} catch (Exception e) {
							
						}finally{
						
						}
					}
				}
				
			}).start();*/
			
			
			
		/*	new Thread(new Runnable(){
				public void run() {
					while(true){
						try {
							String url = "http://localhost:8888/redis/get";
							Map<String, Object> data = Maps.newHashMap();
							String s = HttpUtils.httppost(url, data);
							System.out.println("8888|"+s);
							Integer d = (int) (1000+Math.random()*1000);
							Thread.sleep(Long.parseLong(d.toString()));
						} catch (Exception e) {
							
						}finally{
						
						}
					}
				}
				
			}).start();
			*/
			
			
			
			new Thread(new Runnable(){
				public void run() {
					while(true){
						try {
							//String url = "http://localhost:9999/token/get";
							String url = "http://172.16.30.10:9999/token/get";
							Map<String, Object> data = Maps.newHashMap();
							String s = HttpUtils.httppost(url, data);
							System.out.println(format.format(new Date())+"|9999|"+s);
							Integer d = (int) (3000+Math.random()*7000);
							Thread.sleep(Long.parseLong(d.toString()));
						} catch (Exception e) {
							
						}finally{
						
						}
					}
				}
				
			}).start();
		}
		
	
		
		
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
