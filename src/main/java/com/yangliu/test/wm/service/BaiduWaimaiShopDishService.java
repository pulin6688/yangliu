package com.yangliu.test.wm.service;

import java.util.TreeMap;

import com.yangliu.test.wm.BaiduAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yangliu.test.wm.to.dish.CreateDishCategoryTO;
import com.yangliu.test.wm.to.dish.CreateDishTO;
import com.yangliu.test.wm.to.dish.DeleteDishTO;
import com.yangliu.test.wm.utils.BuildDataUtils;
import com.yangliu.test.wm.utils.Cmd;
import com.yangliu.utils.HttpUtils;

/**
 * 百度外卖门店菜品操作
 * @author pul
 *
 */
@Service
public class BaiduWaimaiShopDishService {
	
	private static final String DISH_CREATE   = "dish.create";  //菜品创建
	private static final String DISH_UPDATE   = "dish.update";  //菜品修改
	private static final String DISH_SHOW     = "dish.show";    //菜单查看
	private static final String DISH_ONLINE   = "dish.online";  //菜品上线
	private static final String DISH_OFFLINE  = "dish.offline"; //菜品下线
	private static final String DISH_DELETE   = "dish.delete";  //菜品删除
	private static final String DISH_SALEOUT  = "dish.saleout"; //菜品停售
	private static final String DISH_CATEGORY_CREATE    = "dish.category.create";//新增菜品分类
	private static final String DISH_CATEGORY_UPDATE    = "dish.category.update";//修改菜品分类
	
	
	private static Logger logger =  LoggerFactory.getLogger(BaiduWaimaiShopDishService.class);
	
	

	
	public void dishCreate(CreateDishTO to) {
		 dishCreateOrUpdate(to,DISH_CREATE);
	}
	public void dishUpdate(CreateDishTO to){
		 dishCreateOrUpdate(to,DISH_UPDATE);
	}
	public void dishOnline(DeleteDishTO to){
		 dishOperate(to,DISH_ONLINE);
	}
	public void dishOffline(DeleteDishTO to){
		 dishOperate(to,DISH_OFFLINE);
	}
	public void dishDelete(DeleteDishTO to){
		 dishOperate(to,DISH_DELETE);
	}
	
	
	public void dishOperate(DeleteDishTO to,String cmd) {
		logger.info("cmd:{}",cmd);
		
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.build(to);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
		
		
	}
	
	
	public void dishShow(DeleteDishTO to){
		logger.info("cmd:{}",DISH_SHOW);
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.build(to);
			String jsonRequestBody = Cmd.getRequestSubmit(DISH_SHOW, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
		
		
	}
	
	
	/**
	 * 菜品创建
	 * @param to
	 * @return
	 * @throws
	 */
	public void dishCreateOrUpdate(CreateDishTO to,String cmd){
		logger.info("cmd:{}",cmd);
		
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.build(to);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品操作失败，error:", e);
		}
		
		
	}
	
	
	
	/**
	 * 菜品分类创建
	 * @param to
	 * @return
	 * @throws
	 */
	public void dishCategoryCreate(CreateDishCategoryTO to){
		 dishCategory(to,DISH_CATEGORY_CREATE);
	}
	
	/**
	 * 菜品分类修改
	 * @param to
	 * @return
	 * @throws
	 */
	public void dishCategoryUpdate(CreateDishCategoryTO to){
		 dishCategory(to,DISH_CATEGORY_UPDATE);
	}
		
		
		
		
	private  void dishCategory(CreateDishCategoryTO to,String cmd){
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.build(to);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(BaiduAccount.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("商户菜品分类操作失败，error:", e);
		}

	}
	
	
}
