package com.yangliu.dianping;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TestProd {
	public static void main(String[] args) throws Exception {
		String d = FileUtils.readFileToString(new File("D:/dazhongdianping/a.txt"));
		//System.out.println(d);
		
		String appKey = "SqfKyzyBRkPRxk7qn3SG9Q==";
		String token = "SHISHIKE-POS";
		
		String sign = CypherUtil.getSign(appKey);
		//获取encodeKey
		String encodeKey = CypherUtil.getEncodeKey(sign,token);
		String s = CypherUtil.decode(encodeKey, d);
		System.out.println(s);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(1480680345900L));
		System.out.println(date);
	}
}
