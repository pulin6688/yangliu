package com.yangliu.test.wm;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.service.BaiduWaimaiOrderService;
import com.yangliu.test.wm.service.BaiduWaimaiShopDishService;
import com.yangliu.test.wm.service.BaiduWaimaiShopService;
import com.yangliu.test.wm.to.dish.CreateDishCategoryTO;
import com.yangliu.test.wm.to.dish.CreateDishTO;
import com.yangliu.test.wm.to.dish.DeleteDishTO;
import com.yangliu.test.wm.to.order.OrderCancelByYanshouTO;
import com.yangliu.test.wm.to.order.OrderCompleteByYanshouTO;
import com.yangliu.test.wm.to.order.OrderStatusPushByYanshouTO;
import com.yangliu.test.wm.to.shop.CreateShopTO;
import com.yangliu.test.wm.to.shop.ModifyShopStatusTO;
import com.yangliu.test.wm.to.shop.ShopPicUploadNewTO;
import com.yangliu.test.wm.to.shop.ShopPicUploadTO;

public class YanshouTest {
	
	private static BaiduWaimaiShopService baiduWaimaiShopService = new BaiduWaimaiShopService();
	
	private static BaiduWaimaiShopDishService baiduWaimaiShopDishService = new BaiduWaimaiShopDishService();
	
	private static BaiduWaimaiOrderService baiduWaimaiOrderService = new BaiduWaimaiOrderService();
	
	
	public static String base = "/Users/mac/baiduwaimai";
	
	public static void main(String[] args) throws Exception {


		//updateShop();
		


		//createShop();//创建商户
		//offlineShop();//下线商户
		//closeShop();//商户歇业
		openAndCreateDish();//商户开业




		//picUpload();//上传资质图片 旧接口
		
		
		//
		//updateDishCategory();
		
		
		//
		
		//updateDish();
		//deleteDish();
		
		//查看菜单
		//showDish();
		
		
		//orderConfirm();
		
		//orderCancel();
		
		//orderStatusPush();
		
		
		//orderComplete();
	}

	public static void openAndCreateDish()throws Exception{
		openShop();//商户开业
		picUploadNew();//上传资质图片 新接口
		createDishCategory();
		createDish();
	}
	
	
	
	//===============shop==================
	
	
	public static void createShop() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/shop.txt"), "gbk");
		CreateShopTO to = JSON.parseObject(json, CreateShopTO.class);
		baiduWaimaiShopService.createShop(to);
	}
	public static void updateShop() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/shop.txt"), "gbk");
		CreateShopTO to = JSON.parseObject(json, CreateShopTO.class);
		baiduWaimaiShopService.updateShop(to);
	}
	public static void openShop() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/open.txt"), "gbk");
		ModifyShopStatusTO to = JSON.parseObject(json, ModifyShopStatusTO.class);
		baiduWaimaiShopService.openShop(to);
	}
	public static void offlineShop() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/open.txt"), "gbk");
		ModifyShopStatusTO to = JSON.parseObject(json, ModifyShopStatusTO.class);
		baiduWaimaiShopService.offlineShop(to);
	}
	public static void closeShop() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/open.txt"), "gbk");
		ModifyShopStatusTO to = JSON.parseObject(json, ModifyShopStatusTO.class);
		baiduWaimaiShopService.closeShop(to);
	}
	public static void picUpload() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/picUpload.txt"), "gbk");
		ShopPicUploadTO to = JSON.parseObject(json, ShopPicUploadTO.class);
		baiduWaimaiShopService.shopPicUpload(to);
	}
	
	public static void picUploadNew() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/picUploadNew.txt"), "gbk");
		ShopPicUploadNewTO to = JSON.parseObject(json, ShopPicUploadNewTO.class);
		baiduWaimaiShopService.shopPicUploadNew(to);
	}
	
	
	
	
	
	//=======dish category=========
	
	public static void createDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dishCategory.txt"), "gbk");
		CreateDishCategoryTO to = JSON.parseObject(json, CreateDishCategoryTO.class);
		baiduWaimaiShopDishService.dishCategoryCreate(to);
	}
	public static void updateDishCategory() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dishCategoryUpdate.txt"), "gbk");
		CreateDishCategoryTO to = JSON.parseObject(json, CreateDishCategoryTO.class);
		baiduWaimaiShopDishService.dishCategoryUpdate(to);
	}
	
	
	
	
	//=======dish=========
	
	public static void createDish() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dish.txt"), "gbk");
		CreateDishTO to = JSON.parseObject(json, CreateDishTO.class);
		baiduWaimaiShopDishService.dishCreate(to);
	}
	public static void updateDish() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dish.txt"), "gbk");
		CreateDishTO to = JSON.parseObject(json, CreateDishTO.class);
		baiduWaimaiShopDishService.dishUpdate(to);
	}
	public static void deleteDish() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dishDelete.txt"), "gbk");
		DeleteDishTO to = JSON.parseObject(json, DeleteDishTO.class);
		baiduWaimaiShopDishService.dishDelete(to);
	}
	public static void showDish() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/dishShow.txt"), "gbk");
		DeleteDishTO to = JSON.parseObject(json, DeleteDishTO.class);
		baiduWaimaiShopDishService.dishShow(to);
	}
	
	
	
	
	//================order======================
	public static void orderConfirm() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/orderConfirm.txt"), "gbk");
		OrderCompleteByYanshouTO to = JSON.parseObject(json, OrderCompleteByYanshouTO.class);
		baiduWaimaiOrderService.orderComfirm(to);
	}
	public static void orderComplete() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/orderComplete.txt"), "gbk");
		OrderCompleteByYanshouTO to = JSON.parseObject(json, OrderCompleteByYanshouTO.class);
		baiduWaimaiOrderService.orderComplete(to);
	}
	public static void orderCancel() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/orderCancel.txt"), "gbk");
		//System.out.println(json);
		OrderCancelByYanshouTO to = JSON.parseObject(json, OrderCancelByYanshouTO.class);
		baiduWaimaiOrderService.orderCancel(to);
	}
	public static void orderStatusPush() throws Exception {
		String json = FileUtils.readFileToString(new File(base+"/orderStatusPush.txt"), "gbk");
		OrderStatusPushByYanshouTO to = JSON.parseObject(json, OrderStatusPushByYanshouTO.class);
		baiduWaimaiOrderService.orderStatusPush(to);
	}
	
	
	
	
}
