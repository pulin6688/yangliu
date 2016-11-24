package com.yangliu.test.wm.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yangliu.test.wm.to.shop.BusinessTimeTO;
import com.yangliu.test.wm.to.shop.CategorysTO;
import com.yangliu.test.wm.to.shop.CreateShopTO;
import com.yangliu.test.wm.to.shop.DeliveryRegion;
import com.yangliu.test.wm.to.shop.DeliveryRegionTO;



/**
 * 百度外卖数据构造工具类
 * @author pul
 *
 */
public class BuildDataUtils {
	
	private static Logger logger =  LoggerFactory.getLogger(BuildDataUtils.class);
	
	/**
	 * 构造创建百度外卖门店的数据结构
	 * @param to
	 * @return
	 */
	public static TreeMap<String, Object> buildShopMap(CreateShopTO to){
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("shop_id", to.getShop_id());
		reqMap.put("name", to.getName());
		reqMap.put("province", to.getProvince());
		reqMap.put("city", to.getCity());
		reqMap.put("county", to.getCounty());
		reqMap.put("address", to.getAddress());

		List<TreeMap<String, String>> categorys = new ArrayList();
		for(CategorysTO category : to.getCategorys()){
			TreeMap<String, String> cateMap = new TreeMap();
			cateMap.put("category1", category.getCategory1());
			cateMap.put("category2", category.getCategory2());
			cateMap.put("category3", category.getCategory3());
			categorys.add(cateMap);
		}
		reqMap.put("categorys", categorys);

		reqMap.put("phone", to.getPhone());
		reqMap.put("service_phone", to.getService_phone());
		reqMap.put("longitude", to.getLongitude());// 经度
		reqMap.put("latitude", to.getLatitude());// 纬度

		List<TreeMap<String, String>> businessTime = new ArrayList();
		for(BusinessTimeTO time : to.getBusiness_time()){
			TreeMap<String, String> timeMap = new TreeMap();
			timeMap.put("start", time.getStart());
			timeMap.put("end", time.getEnd());
			businessTime.add(timeMap);
		}
		reqMap.put("business_time", businessTime);

		
		
		
		
		for(DeliveryRegionTO regionTO : to.getDelivery_region()){
			List<TreeMap<String, String>> regionList = new ArrayList();
			
			List<List<DeliveryRegion>>  s = regionTO.getRegion();
			for(int i=0;i<s.size();i++){
				List<DeliveryRegion> k = s.get(i);
				for(DeliveryRegion r : k){
					TreeMap<String, String> region = new TreeMap();
					region.put("latitude",r.getLatitude());
					region.put("longitude", r.getLongitude());
					regionList.add(region);
				}
			}
			
			TreeMap<String, Object> deliveryRegion = new TreeMap();
			deliveryRegion.put("name", regionTO.getName());
			deliveryRegion.put("delivery_time",regionTO.getDelivery_time());//
			deliveryRegion.put("delivery_fee", regionTO.getDelivery_fee());//分，配送费只支持整元
			List<List<TreeMap<String, String>>> regionListAll = new ArrayList();
			regionListAll.add(regionList);
			deliveryRegion.put("region", regionListAll);
			
			List<TreeMap<String, Object>> deliveryRegions = new ArrayList();
			deliveryRegions.add(deliveryRegion);
			reqMap.put("delivery_region", deliveryRegions);
		}
		reqMap.put("invoice_support", to.getInvoice_support());
		reqMap.put("min_order_price", to.getMin_order_price());
		reqMap.put("package_box_price", to.getPackage_box_price());
		return reqMap;
	}
	
	

	
    public static TreeMap<String, Object> build(Object obj) {
    	
    	TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
      
    	Class<?> clazz = obj.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fs = clazz.getDeclaredFields();
                for (int i = 0; i < fs.length; i++) {
                    Field f = fs[i];
                    f.setAccessible(true); // 设置些属性是可以访问的
                    String name = f.getName();
                    if (name.equalsIgnoreCase("serialVersionUID")) {
                        continue;
                    }
                    // 得到此属性的值
                    Object value = f.get(obj);
                    if (value != null) {
                        reqMap.put(name, value);
                    }
                    f.setAccessible(false);
                }
            } catch (Exception e) {
                logger.error("build treemap dada error :{}", e);
                // 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会执行clazz =
                // clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }//for end
        
        return reqMap;
    }
    
    
}
