package com.yangliu.nuomi.coupon;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.facebook.presto.jdbc.internal.guava.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class Test {
	public static void main(String[] args) throws Exception {

		nuomi();
		//m();
		//meituan();
			 
	}
	
	public static void nuomi() throws Exception{
		String method = "nuomi.serviceCenter.cert.thirdpart.query";
		String appid = "yU4wrFj5bE";
		String token = "67ab1b83aa0e8c87d972e7364ac4c9e8";
		String code = "603480417065";
		String email = "lalal@baidu.com";
		String url = "http://testapi.nuomi.com/nop/server/rest";
		Map<String,Object>  param = BuildNuomiRequestUtil.build(method, appid, token, code, email);
		String json = JSON.toJSONString(param);
		System.out.println(json);
		HttpUtils.httppost(url, param);
	}
	
	
	public static void meituan() throws Exception{
		String json = FileUtils.readFileToString(new File("D:/meituan/aa.txt"), "gbk");
		String url = "http://gldpartner.keruyun.com/api/cater/takeout/meituan/order/create";
		Map<String,Object>  param = Maps.newHashMap();
		param.put("developerId", "100207");
		param.put("ePoiId", "247900001");
		param.put("sign", "6a26d75a4c8e2e4e548295419b79be63477dfc12");
		param.put("order", json);
		HttpUtils.httppost(url, param);
	}
	
	
	public static void m(){
		String s="code=111nop_appid=yU4wrFj5bEnop_debug=1nop_method=nuomi.serviceCenter.cert.thirdpart.querynop_timestamp=1482398171userEmail=lalal@baidu.com";
		  
		System.out.println(  BuildNuomiRequestUtil.MD5(s) );
			   s="code=111nop_appid=yU4wrFj5bEnop_debug=1nop_method=nuomi.serviceCenter.cert.thirdpart.querynop_timestamp=1482398171userEmail=lalal@baidu.com67ab1b83aa0e8c87d972e7364ac4c9e8";
	    System.out.println(  BuildNuomiRequestUtil.MD5(s) );
	}
}
