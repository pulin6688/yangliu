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
    
//  private static final String account="65487";
//  private static final String secret="85bff21a43cb8da6";
    
//    private static final String account="65390";
//    private static final String secret="6f48db35eef9c822";
    
    //鲜芋仙（百宜味）
   // private static final String account="65090";
    //private static final String secret="cf989e123388b572";

    
    //木岚饮品测试账号
    //private static final String account="65079";
    //private static final String secret="9b8077a370854713";
    
    
    
    
    
    
    
    //两江新区万里餐饮店测试验收店
//    private static final String account="65065";
//    private static final String secret="bda14595dfe0e438";
    
  //两江新区万里餐饮店正式店
    //private static final String account="30415";
    //private static final String secret="78e6106da42b282d";
    
    
    
    
   
    //湖南刘先生餐饮管理验收账号
//    private static final String account="65055";
//    private static final String secret="0d399cfe1fee198b";
    
    //德川家测试
//    private static final String account="65053";
//    private static final String secret="c7aaa2759d94952f";
    // 德川家API测试店
//    private static final String account="65045";
//    private static final String secret="196d02062fb1bec6";
    
    //王的炒饭API测试店  1887870435
    //private static final String account="65017";
    //private static final String secret="dd459b4ede2cd3f1";
    
    
    
    
    //壹寿司API测试店
//    private static final String account="65011";
//    private static final String secret="e715da3525b6fac9";
    
    //广州巴先生面馆API测试店
//    private static final String account="64978";
//    private static final String secret="8330fdb8209e3d8b";
    
   //吃个汤API测试店
//    private static final String account="64973";
//    private static final String secret="eeaaa99ab6bebd34";
    
    //佬友记API测试店
//    private static final String account="64969";
//    private static final String secret="48537a731a78ce6b";
    
    
    //西安小米串串API测试店
    private static final String account="64968";
    private static final String secret="e008b3bb71f58119";
   
    
   
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