package com.yangliu.test.wm.utils;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.yangliu.utils.MD5Utils;



/**
 * 请求百度外卖接口参数封装
 */
public class Cmd implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7043195043055224479L;
	public static final Logger logger = LoggerFactory.getLogger(Cmd.class);
    public final static String VERSION = "2";
    
//    private static final String account="65390";
//    private static final String secret="6f48db35eef9c822";
    
    //鲜芋仙（百宜味）
   // private static final String account="65090";
    //private static final String secret="cf989e123388b572";
    
//    private static final String account="65487";
//    private static final String secret="85bff21a43cb8da6";
    
    
    
    //木岚饮品测试账号
    private static final String account="65079";
    private static final String secret="9b8077a370854713";
   
    
   
    public static final String URL = "http://api.waimai.baidu.com";


    /**
     * unicode 转码
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
    
    
	/**
	 * 获取百度请求的签名
	 */
	public static String getSign(TreeMap<String, Object> requestMap) {
		//String json = gson.toJson(requestMap);
		String json = JSON.toJSONString(requestMap);
		json = json.replaceAll("/","\\\\\\/");  // 将 / 替换为 \/  百度地图签名需要
		//json = json.replaceAll("\\\\/","/");  // 将 \/ 替换为 /
		String signjson = chinaToUnicode(json); // 转码为unicode
		logger.info("+++++++++++++++old_json:{}",json);
		logger.info("+++++++++++++++sign_json:{}",signjson);
		String md5Sign = MD5Utils.md5(signjson).toUpperCase();
		return md5Sign;
	}
    

	
	
	
	public static TreeMap<String, Object> getRequestMap(String cmd, TreeMap<String, Object> body) {
		TreeMap<String, Object> map = new TreeMap<String, Object>();
		map.put("cmd", cmd);
		map.put("timestamp", System.currentTimeMillis() / 1000);
		map.put("version", VERSION);
		map.put("ticket", UUID.randomUUID().toString().toUpperCase());
		map.put("body", body);
		map.put("source", account);
		map.put("secret", secret);
		return map;
	}
	
	/**
	 * 获取请求体
	 */
	public static String getRequestSubmit(String cmd,TreeMap<String, Object> body) {
		TreeMap<String, Object> requestMap = getRequestMap(cmd, body);
		String md5Sign = getSign(requestMap);//计算sign的时候需要加上secret
		requestMap.put("sign", md5Sign);
		requestMap.remove("secret");//计算完sign后移除secret
		//String json = gson.toJson(requestMap);//计算
		String json = JSON.toJSONString(requestMap);
		logger.info("send to baiduwaimai data:"+json);
		return json;
	}
	

	
	/**
	 * 获取响应体
	 */
	public static String getResponse(String cmd,String account,String secret,TreeMap<String, Object> body) {
		TreeMap<String, Object> requestMap = getRequestMap(cmd,body);
		String md5Sign = getSign(requestMap);
		requestMap.put("sign", md5Sign);
        requestMap.remove("secret");
		//return chinaToUnicode(gson.toJson(requestMap));
		return chinaToUnicode(JSON.toJSONString(requestMap));
	}
	

}