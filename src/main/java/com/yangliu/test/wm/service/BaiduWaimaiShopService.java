package com.yangliu.test.wm.service;

import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yangliu.test.wm.to.shop.CreateShopTO;
import com.yangliu.test.wm.to.shop.ModifyShopStatusTO;
import com.yangliu.test.wm.to.shop.ShopPicUploadTO;
import com.yangliu.test.wm.utils.BuildDataUtils;
import com.yangliu.test.wm.utils.Cmd;
import com.yangliu.utils.HttpUtils;


/**
 * 百度外卖门店操作(商户创建 商户下线 商户开业 商户 歇业) service
 * @author pul
 *
 */
@Service
public class BaiduWaimaiShopService {
	
	private static final String SHOP_CREATE  = "shop.create";
	private static final String SHOP_UPDATE  = "shop.update";
	private static final String SHOP_OPEN    = "shop.open";
	private static final String SHOP_CLOSE   = "shop.close";
	private static final String SHOP_OFFLINE = "shop.offline";
	private static final String SHOP_PIC_UPLOAD = "shop.pic.upload";//商户资质图片上传
	
	
	private static Logger logger =  LoggerFactory.getLogger(BaiduWaimaiShopService.class);

	

	public void createShop(CreateShopTO to) {
		 shop(to,SHOP_CREATE);
	}
	
	public void updateShop(CreateShopTO to) {
		 shop(to,SHOP_UPDATE);
	}
	
	/**
	 * 商户操作
	 * @param to
	 * @return
	 * @throws ServiceException
	 */
	private void shop(CreateShopTO to,String cmd) {
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.buildShopMap(to);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		} catch (Exception e) {
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
	}
	
	
	/**
	 * 商户开业
	 * @param to
	 * @return
	 * @throws ServiceException
	 */
	public void openShop(ModifyShopStatusTO to){
		 commonStatusModify(to,SHOP_OPEN);
	}
	
	
	/**
	 * 下线商户
	 * @return
	 */
	public void offlineShop(ModifyShopStatusTO to) {
		 commonStatusModify(to,SHOP_OFFLINE);
	}
	
	/**
	 * 商户歇业
	 * @return
	 */
	public void closeShop(ModifyShopStatusTO to) {
		 commonStatusModify(to,SHOP_CLOSE);
	}
	
	/**
	 * 商户资质图片上传
	 * @param to
	 * @return
	 * @throws ServiceException
	 */
	public void shopPicUpload(ShopPicUploadTO to){
		String cmd = SHOP_PIC_UPLOAD;
		logger.info("cmd:{}",cmd);
		try {
			TreeMap<String, Object> reqMap = BuildDataUtils.build(to);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		}catch(Exception e){
			logger.error("百度外卖验收测试商户失败，error:", e);
		}
		
	}
	
	
	
	
	private void commonStatusModify(ModifyShopStatusTO to,String cmd) {
		logger.info("cmd:{}",cmd);
		Long shopId = to.getShop_id();
		try {
			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
			reqMap.put("shop_id", shopId);
			String jsonRequestBody = Cmd.getRequestSubmit(cmd, reqMap);
			logger.info("jsonRequestBody:{}",jsonRequestBody);
			HttpUtils.httppostJson(Cmd.URL, jsonRequestBody);
		}catch(Exception e){
			logger.error("百度外卖商户操作cmd:"+cmd+"失败,error:", e);
		}
		
	
	}
	
	
	/**
	 *  门店创建
	 * @param shopId
	 * @return
	 * @throws ServiceException
	 */
	
//	public Response<Object> createShop(Long shopId) throws ServiceException {
//		Response<Object> response = new Response<>(ErrorType.OK);
//
//		try {
//			Commercial shop = commercialDao.get(shopId);
//
//			
//			if (shop == null) {
//				response.setResponseMessage(ErrorType.SHOP_NOT_EXISTS, String.format("商户shopId=%s不存在", shopId));
//				return response;
//			}
//			
//			PartnerThirdMatch partnerBaiduWaimaiMatch = partnerThirdMatchDao.getByShopIdAndSource(
//					shopId,
//					TradeSourceType.BAIDU_WAIMAI.getKey(),
//					null);
//			
//			if (partnerBaiduWaimaiMatch == null) {
//				response.setResponseMessage(ErrorType.BUSINESS_ERROR, String.format("商户对接百度外卖配置信息不存在，请配置", shopId));
//				return response;
//			}
//
//			TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
//			reqMap.put("shop_id", shopId);
//			reqMap.put("name", shop.getCommercialName());
//			reqMap.put("province", "四川省");
//			reqMap.put("city", "成都市");
//			reqMap.put("county", "武侯区");
//			reqMap.put("address", "科华北路143号");
//
//			List<TreeMap<String, String>> categorys = new ArrayList<>();
//			TreeMap<String, String> cateMap = new TreeMap<>();
//			cateMap.put("category1", "餐饮");
//			cateMap.put("category2", "小吃快餐");
//			cateMap.put("category3", "家常小炒");
//			categorys.add(cateMap);
//			reqMap.put("categorys", categorys);
//
//			reqMap.put("phone", "13608050511");
//			reqMap.put("service_phone", "028-81112222");
//			reqMap.put("longitude", "104.083451");// 经度
//			reqMap.put("latitude", "30.628954");// 纬度
//
//			//
//			List<TreeMap<String, String>> businessTime = new ArrayList<>();
//			TreeMap<String, String> timeMap = new TreeMap<>();
//			timeMap.put("start", "00:10");
//			timeMap.put("end", "23:59");
//			businessTime.add(timeMap);
//			reqMap.put("business_time", businessTime);
//
//			List<TreeMap<String, Object>> deliveryRegions = new ArrayList<>();
//			TreeMap<String, Object> deliveryRegion = new TreeMap<>();
//			deliveryRegion.put("name", "第一配送区");
//			deliveryRegion.put("delivery_time", "30");//
//			deliveryRegion.put("delivery_fee", "100");//分，配送费只支持整元
//			
//			
//			List<List<TreeMap<String, String>>> regions = new ArrayList<>();
//			List<TreeMap<String, String>> regionListMaps = new ArrayList<>();
//			
//			TreeMap<String, String> regionMap1 = new TreeMap<>();
//			regionMap1.put("latitude", "30.639671");
//			regionMap1.put("longitude", "104.073391");
//			regionListMaps.add(regionMap1);
//			
//			TreeMap<String, String> regionMap2 = new TreeMap<>();
//			regionMap2.put("latitude", "30.639671");
//			regionMap2.put("longitude", "104.093197");
//			regionListMaps.add(regionMap2);
//			
//			TreeMap<String, String> regionMap3 = new TreeMap<>();
//			regionMap3.put("latitude", "30.626711");
//			regionMap3.put("longitude", "104.093197");
//			regionListMaps.add(regionMap3);
//			
//			TreeMap<String, String> regionMap4 = new TreeMap<>();
//			regionMap4.put("latitude", "30.626711");
//			regionMap4.put("longitude", "104.073391");
//			regionListMaps.add(regionMap4);
//			
//			TreeMap<String, String> regionMap5 = new TreeMap<>();
//			regionMap5.put("latitude", "30.639671");
//			regionMap5.put("longitude", "104.073391");
//			regionListMaps.add(regionMap5);
//			
//			regions.add(regionListMaps);
//			deliveryRegion.put("region", regions);
//			
//			deliveryRegions.add(deliveryRegion);
//			reqMap.put("delivery_region", deliveryRegions);
//
//			reqMap.put("invoice_support", "2");
//			reqMap.put("min_order_price", "1");
//			reqMap.put("package_box_price", "1");
//
//			String cmd = SHOP_CREATE;
//
//			String jsonRequestBody = Cmd.getRequestSubmit(cmd, partnerBaiduWaimaiMatch, reqMap);
//			String postResult = BaiduTakeoutHttpClient.postJson(jsonRequestBody);
//			if (StringUtils.isNotBlank(postResult)) {
//				BaiduTakeoutResultVO<BaiduTakeoutBody> baiduTakeoutResultVO = GsonWrapper.fromJson(postResult,
//						new TypeToken<BaiduTakeoutResultVO<BaiduTakeoutBody>>() {
//						});
//				if (baiduTakeoutResultVO != null) {
//					BaiduTakeoutBody returnBody = baiduTakeoutResultVO.getBody();
//					if (returnBody != null) {
//						int errno = returnBody.getErrno();
//						if (errno == 0) {
//							Object data = returnBody.getData();
//							response.setResponseBody(data);
//						} else {
//							throw new ServiceException(ErrorType.SYSTEM_ERROR, "创建百度外卖验收测试商户失败," + "errno:" + errno + "-"
//									+ BaiduTakeoutErrorType.getType(errno).getValue());
//						}
//					}
//				}
//			}
//
//		} catch (DaoException e) {
//			logger.error("创建百度外卖验收测试商户失败，error:", e);
//			response.setResponseMessage(ErrorType.BUSINESS_ERROR, "创建百度外卖验收测试商户失败，shopId="+shopId);
//		}
//		return response;
//	}
	
	
	

	
	
	
	
	
}
