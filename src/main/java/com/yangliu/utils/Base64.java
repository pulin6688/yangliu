package com.yangliu.utils;
/*package com.pl.jfinal.utils;

import java.io.UnsupportedEncodingException;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class Base64 {
	// 加密  
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new Base64Encoder().encode(b);
        }
        return s;
    }
  
    // 解密  
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }  
}
*/