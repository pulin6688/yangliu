package com.yangliu.utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUuid(){
		String uuid = UUID.randomUUID().toString();
		return uuid.toString().replace("-", ""); 
	}
}
