package com.yangliu.dianping;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hui.yao
 * @Time 2015年11月4日 下午5:06:35 加解密工具类
 */
public class CypherUtil {

	/**
	 * 根据点评给的key,生成sign, sign需要放到请求的content,具体使用方法见开发者文档
	 * 
	 * @param key
	 *            (128位AES秘钥转Base64)
	 * @return sign (128位AES秘钥转Base64)
	 * @throws Exception
	 */
	public static String getSign(String key) throws Exception {
		return get128SHAKey(key);
	}

	/**
	 * 根据生成的sign和token生成最终加密的EncodeKey
	 * 
	 * @param sign
	 *            (128位AES秘钥转Base64)
	 * @param token
	 *            (厂商token)
	 * @return EncodeKey (128位AES秘钥转Base64)
	 * @throws Exception
	 */
	public static String getEncodeKey(String sign, String token) throws Exception {
		return get128SHAKey(sign + token);
	}

	/**
	 * AES加密
	 * 
	 * @param encodeKey
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String encode(String encodeKey, String content) throws Exception {
		SimpleStringCypher cypher1 = new SimpleStringCypher(encodeKey);
		return cypher1.encrypt(content);
	}

	/**
	 * AES解密
	 * 
	 * @param encodeKey
	 * @param encoded
	 * @return
	 * @throws Exception
	 */
	public static String decode(String encodeKey, String encoded) throws Exception {
		SimpleStringCypher cypher1 = new SimpleStringCypher(encodeKey);
		return cypher1.decrypt(encoded);
	}

	private static String get128SHAKey(String S1) throws Exception {
		MessageDigest digest = java.security.MessageDigest
			.getInstance("SHA-1");
		digest.update(S1.getBytes("UTF-8"));
		byte messageDigest[] = digest.digest();
		byte[] result = new byte[16];
		System.arraycopy(messageDigest, 0, result, 0, 16);
		return Base64.encodeBase64String(result);
	}

}
