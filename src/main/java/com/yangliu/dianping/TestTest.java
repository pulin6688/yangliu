package com.yangliu.dianping;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

public class TestTest {
	public static void main(String[] args) throws Exception {
		String a = FileUtils.readFileToString(new File("D:/dazhongdianping/a.txt"),"gbk");
		String b = FileUtils.readFileToString(new File("D:/dazhongdianping/b.txt"),"gbk");
		
		String appKey = "SqfKyzyBRkPRxk7qn3SG9Q==";
		String token = "SHISHIKE-POS";
		
		String sign = CypherUtil.getSign(appKey);
		//获取encodeKey
		String encodeKey = CypherUtil.getEncodeKey(sign,token);
		
		System.out.println(CypherUtil.encode(encodeKey, a));
		
		Map<String,Object> map = Maps.newHashMap();
		//System.out.println(a);
		
		map.put("content", CypherUtil.encode(encodeKey, a));
		String url = "https://testpartner.shishike.com/api/cater/dinner/dianping/order/create";
		//HttpUtils.httppost(url, map);
		
		
		
		//System.out.println( CypherUtil.decode(encodeKey, b));
		
		
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = sdf.format(new Date(1480680345900L));
//		System.out.println(date);
	}
}
