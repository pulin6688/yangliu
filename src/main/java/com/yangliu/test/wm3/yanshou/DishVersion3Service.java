package com.yangliu.test.wm3.yanshou;

import java.util.TreeMap;

import com.yangliu.test.wm3.CmdV3;
import com.yangliu.test.wm3.DishMenuGetTO;
import com.yangliu.test.wm3.OrderCancelTO;
import com.yangliu.test.wm3.OrderStatusGetTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.BaiduAccount;
import com.yangliu.test.wm.utils.BuildDataUtils;
import com.yangliu.utils.HttpUtils;

/**
 * 百度外卖门店菜品操作 version3   菜单查看
 * @author pul
 *
 */
public class DishVersion3Service {
	
	private static final String DISH_CATEGORY_ALL   = "dish.category.all";  //菜品分类查看
	private static final String DISH_GET   = "dish.get";  //  菜品查看
	private static final String DISH_MENU_GET   = "dish.menu.get";  //查看菜单
	private static final String ORDER_STATUS_GET   = "order.status.get";  //订单状态查看
	private static final String ORDER_CANCEL   = "order.cancel";  //订单状态查看


	private static Logger logger =  LoggerFactory.getLogger(DishVersion3Service.class);


	public static void main(String[] args){
		DishVersion3Service service = new DishVersion3Service();
		DishMenuGetTO to = new DishMenuGetTO();
		//to.setBaidu_dish_id("1496476931");
		//to.setShop_id("247900001");
		to.setShop_id("810048382");
		service.dishMenuGet(to);
		//service.dishGet(to);
	}




    /**
	 * 菜单查询
	 * @param to
	 */
	public void dishMenuGet(DishMenuGetTO to){
		logger.info("cmd:{}",DISH_MENU_GET);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(DISH_MENU_GET, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}

	/**
	 * 菜品查询
	 * @param to
     */
	public void dishGet(DishMenuGetTO to){
		logger.info("cmd:{}",DISH_GET);
		try {
			TreeMap<String, Object> body = BuildDataUtils.build(to);
			TreeMap<String, Object>  jsonRequestBody = CmdV3.getRequestSubmit(DISH_GET, body);
			logger.info("jsonRequestBody:{}",JSON.toJSONString(jsonRequestBody));
			HttpUtils.httppost(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
	}
	




	






	
	

}
