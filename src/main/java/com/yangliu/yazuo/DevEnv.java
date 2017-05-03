package com.yangliu.yazuo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class DevEnv {
	
	public static SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms"); 
	
	public static void main(String[] args)  throws Exception{


		//授权
		Map<String, Object>  param = Maps.newHashMap();
		param.put("client_id", "keruyun");
		param.put("client_secret", "f845a0e4d8df480c9a809c46f43ddb3e");
		param.put("response_type", "code");
		param.put("scope", "common_scope");
		param.put("thirdparty_merchant_no", "2479");//商家编号 品牌编号
		param.put("thirdparty_merchant_name", "南粉北面高攀路店面");//商家名称 品牌名称
		param.put("thirdparty_store_no", "247900001");//门店编号
		param.put("thirdparty_store_name", "南粉北面南粉北面高攀路店面");//门店名称
		String s = HttpUtils.httppost("https://openapi-p.4008827123.cn/oauth/authorize", param);
		System.out.println(s);

		
		//refresh();
		
		

		
		
		
	
	
	}
	
	
	public static void refresh() throws Exception{
		
		//keruyuntest	0d20815a0c1344909b04432da35a5274
		
		String clientId = "keruyun";
		String clientSecret = "f845a0e4d8df480c9a809c46f43ddb3e";
		String grant_type   =     "refresh_token";
		String refresh_token   =     "dc72fa54d6004710a3e42b53cb25fab8";
		//
		   
		Map<String, Object> param = Maps.newHashMap();
		param.put("client_id", clientId);
		param.put("client_secret", clientSecret);
		param.put("grant_type", grant_type);
		param.put("refresh_token", refresh_token);
		
		String url = "https://openapi-p.4008827123.cn/oauth/token";
		String s = HttpUtils.httppost(url, param);
		
		System.out.println(s);
//		
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
