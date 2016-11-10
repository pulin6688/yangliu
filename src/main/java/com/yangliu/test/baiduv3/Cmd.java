package com.yangliu.test.baiduv3;

import java.io.Serializable;
import java.util.Iterator;
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
    public final static String VERSION_3 = "3";
    
    private static final String account="65390";
    private static final String secret="6f48db35eef9c822";
    
   
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
		StringBuffer sb = new StringBuffer();
		Iterator<String> ite = requestMap.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Object value = requestMap.get(key);
			if(value instanceof String){
				if("".equals(value)){
					sb.append(key).append("=").append("&");
				}else{
					sb.append(key).append("=").append(value).append("&");
				}
				
			}else{
				sb.append(key).append("=").append(JSON.toJSONString(value)).append("&");
			}
			
		}
		
		String s = sb.toString();
		s = s.substring(0, s.lastIndexOf("&"));
		System.out.println("====================:"+s);
		s = chinaToUnicode(s);
		System.out.println("====================:"+s);
		String md5Sign = MD5Utils.md5(s).toUpperCase();
		String md5Sign2 = MD5Utils.md5(s).toUpperCase();
		System.out.println("md5Sign:"+md5Sign);
		System.out.println("md5Sign:"+md5Sign2);
		return md5Sign;
	}
	
	/**
	 * 获取请求体
	 */
//	public static String getRequestSubmit(String cmd,TreeMap<String, Object> body) {
//		TreeMap<String, Object> requestMap = getRequestMap(cmd, body);
//		String md5Sign = getSign(requestMap);//计算sign的时候需要加上secret
//		requestMap.put("sign", md5Sign);
//		requestMap.remove("secret");//计算完sign后移除secret
//		//String json = gson.toJson(requestMap);//计算
//		String json = JSON.toJSONString(requestMap);
//		logger.info("send to baiduwaimai data:"+json);
//		return json;
//	}
	
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
	
	public static TreeMap<String, Object>  getRequestSubmitV3(String cmd, TreeMap<String, Object> body) {
		TreeMap<String, Object> requestMap = getRequestMapV3(cmd, body);
		requestMap.put("encrypt", "");//百度外卖V3.0接口新增字段
		String md5Sign = getSign(requestMap);//计算sign的时候需要加上secret
		requestMap.put("sign", md5Sign);
		requestMap.remove("secret");//计算完sign后移除secret
		
		//String json = gson.toJson(requestMap);//计算
		String json = JSON.toJSONString(requestMap);
		//logger.info("send to baiduwaimai data:"+json);
		
		return requestMap;
	}
	
	public static TreeMap<String, Object> getRequestMapV3(String cmd,TreeMap<String, Object> body) {
		TreeMap<String, Object> map = new TreeMap<String, Object>();
		map.put("cmd", cmd);
		
		map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
		map.put("ticket", UUID.randomUUID().toString().toUpperCase());
		
//		map.put("timestamp", "1478758252");
//		map.put("ticket", "42A81E7D-B15B-4D59-BC4D-E91A2BA7DD35");
		
		map.put("version", VERSION_3);
		map.put("body", body);
		map.put("source",account);
		map.put("secret", secret);

		return map;
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