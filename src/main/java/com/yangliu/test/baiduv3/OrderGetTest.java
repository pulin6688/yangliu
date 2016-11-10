package com.yangliu.test.baiduv3;

import java.util.TreeMap;

import com.yangliu.utils.HttpUtils;

public class OrderGetTest {
	
	public static void main(String[] args) throws Exception {
		TreeMap<String, Object> body = new TreeMap<>();
		body.put("order_id", "14785798481663");
		body = Cmd.getRequestSubmitV3("order.get",body);
		HttpUtils.httppost(Cmd.URL, body);
	}

}
