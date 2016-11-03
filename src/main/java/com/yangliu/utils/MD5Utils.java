package com.yangliu.utils;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author pul@shishike.com
 */
public class MD5Utils {
    /*** 
     * MD5加码 生成32位md5码 
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
        return hexValue.toString();  
  
    } 
    
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }
    
    public static void main(String[] args) {
    	String p = "123456a";
    	String slat = "8af91a763d";
    	System.out.println(MD5("88888943103admin"));
    	
    	String a = DigestUtils.sha(slat)+""+DigestUtils.sha(p)+"";
    	
    	//String s = Base64.getBase64(a);
    	//System.out.println(s);
    	
    	
    	//2lbWfRN39bA8sK7IawFHo95lxXw=
	}

}
