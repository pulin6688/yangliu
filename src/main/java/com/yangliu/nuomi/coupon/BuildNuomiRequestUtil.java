package com.yangliu.nuomi.coupon;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public class BuildNuomiRequestUtil {
	/**
	 * 构建糯米请求参数
	 * @param method
	 * @param appid
	 * @param token
	 * @param to
	 * @return
	 */
	public static Map<String,Object> build(String method,String appid,String token,String code,String email){
		Map<String,Object> m = Maps.newTreeMap();
		m.put("nop_method", method);
		m.put("nop_appid", appid);
		m.put("nop_timestamp", System.currentTimeMillis() / 1000);
		m.put("merchantId", String.valueOf(2845979));
		//m.put("nop_debug", 1);
		
		m.put("code", code);//劵码
		m.put("userEmail", email);//劵码
		//m.put("userEmail", "lalal@baidu.com");//测试验劵账号
		m.put("nop_sign", sign(m,token));
		return m;
	}
	
	
	/**
	 * 糯米签名计算
	 * @param m
	 * @param token
	 * @return
	 */
	public static String sign(Map<String,Object> m,String token){
		 Iterator<String> it= m.keySet().iterator();
	        String checkString = "";
	        //申请的token使用，不传此参数
	        while(it.hasNext()){
	            Object key = it.next();
	            checkString +=key+"="+m.get(key);
	        }
	        checkString += token;
	        //System.out.println("checkString:   "+checkString);
	        String sign = MD5(checkString);
	        //System.out.println("sign:   "+sign);
	        return sign;
	}
	
	/**
	 * MD5加密算法
	 * @param inStr
	 * @return
	 */
	public static String MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toLowerCase();
	 } 

}
