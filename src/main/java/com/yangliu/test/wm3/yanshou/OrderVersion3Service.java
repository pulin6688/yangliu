package com.yangliu.test.wm3.yanshou;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.BaiduAccount;
import com.yangliu.test.wm.utils.BuildDataUtils;
import com.yangliu.test.wm3.CmdV3;
import com.yangliu.test.wm3.OrderCancelTO;
import com.yangliu.test.wm3.OrderVersion3;
import com.yangliu.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

/**
 * 百度外卖门店菜品操作 version3
 * @author pul
 *
 */
public class OrderVersion3Service {
	

	private static final String ORDER_STATUS_GET   = "order.status.get";  //订单状态查看
	private static final String ORDER_CONFIRM   = "order.confirm";  //订单确认
	private static final String ORDER_CANCEL   = "order.cancel";  //订单取消

	private static Logger logger =  LoggerFactory.getLogger(OrderVersion3Service.class);


	public static void main(String[] args){
		OrderVersion3Service service = new OrderVersion3Service();

		String order_id="15014969337397";

		OrderVersion3 t = new OrderVersion3();
		t.setOrder_id(order_id);
		//service.orderStatusGet(t);
		service.orderConfirm(t);//确认订单


		try {
			Thread.sleep(1000*15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		OrderCancelTO cancel = new  OrderCancelTO();
		cancel.setOrder_id(order_id);
		cancel.setType(-1);
		cancel.setReason("cancel");
		service.orderCancel(cancel);//取消订单



	}



	//订单状态查询
	public void orderStatusGet(OrderVersion3 to){
		logger.info("cmd:{}",ORDER_STATUS_GET);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(ORDER_STATUS_GET, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}


	//订单确认
	public void orderConfirm(OrderVersion3 to){
		logger.info("cmd:{}",ORDER_CONFIRM);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(ORDER_CONFIRM, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}


	//订单取消
	public void orderCancel(OrderCancelTO to){
		logger.info("cmd:{}",ORDER_CANCEL);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(ORDER_CANCEL, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}






	
	

}
