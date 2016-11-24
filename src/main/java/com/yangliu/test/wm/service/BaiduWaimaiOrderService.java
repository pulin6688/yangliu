package com.yangliu.test.wm.service;

import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yangliu.test.wm.to.order.OrderCancelByYanshouTO;
import com.yangliu.test.wm.to.order.OrderCompleteByYanshouTO;
import com.yangliu.test.wm.to.order.OrderStatusPushByYanshouTO;
import com.yangliu.test.wm.utils.Cmd;
import com.yangliu.test.wm.utils.CmdV3;
import com.yangliu.utils.HttpUtils;


/**
 * 订单业务处理
 */

public class BaiduWaimaiOrderService {
	
	final static Logger logger = LoggerFactory.getLogger(BaiduWaimaiOrderService.class);
	
	private static final String ORDER_CONFIRM  = "order.confirm";
	private static final String ORDER_COMPLETE  = "order.complete";
	private static final String ORDER_CANCEL  = "order.cancel";
	private static final String ORDER_STATUS_PUSH  = "order.status.push";
	private static final String ORDER_GET  = "order.get";

	
	public void orderComfirm(OrderCompleteByYanshouTO to){
		String cmd = ORDER_CONFIRM;
		logger.info("cmd:{}",cmd);
		//Long shopId = to.getShop_id();
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("order_id", to.getOrder_id());
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	

	
	public void orderComplete(OrderCompleteByYanshouTO to) {
		String cmd = ORDER_COMPLETE;
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("order_id", to.getOrder_id());
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	
	
	public void orderCancel(OrderCancelByYanshouTO to) {
		String cmd = ORDER_CANCEL;
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("shop_id", to.getShop_id());
			reqMap.put("order_id", to.getOrder_id());
			reqMap.put("reason", to.getReason());
			reqMap.put("type", to.getType());
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	
	
	public void orderStatusPush(OrderStatusPushByYanshouTO to){
		String cmd = ORDER_STATUS_PUSH;
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("order_id", to.getOrder_id());
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	
	
	public void orderGet(OrderCompleteByYanshouTO to){
		String cmd = ORDER_GET;
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("order_id", to.getOrder_id());
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	
	public void orderGetV3(OrderCompleteByYanshouTO to){
		TreeMap<String, Object> body = new TreeMap();
		body.put("order_id", "14785798481663");
		body = CmdV3.getRequestSubmit("order.get",body);
		try {
			HttpUtils.httppost(Cmd.URL, body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
