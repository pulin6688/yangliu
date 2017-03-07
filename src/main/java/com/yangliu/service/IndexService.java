package com.yangliu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.yangliu.dao.IndexDao;
import com.yangliu.jms.producer.TestProducer;
import com.yangliu.utils.MD5Utils;

@Service
public class IndexService {
	
	private static Logger logger = LoggerFactory.getLogger(IndexService.class);
	
	static Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build(); 
	
	@Autowired
	private IndexDao indexDao;
	@Autowired
	private TestProducer testProducer;
	
	public List<Map<String,Object>> findByCache(Integer no,Integer size){
		long s = System.currentTimeMillis();
		try{
			if(no == null || no < 1){
				no=1;
			}
			if(size == null || size < 1){
				size = 1;
			}
			Integer start = (no-1) * size;
			String sql = "select commercialID ID,commercialName,commercialAdress,commercialPhone from commercial limit "+start+","+size;
			String key = MD5Utils.MD5(sql);
			String value = cache.getIfPresent(key);
			if(StringUtils.isBlank(value)){
				List<Map<String,Object>> list = indexDao.find(sql);
				String json = JSON.toJSONString(list);
				cache.put(key, json);
				logger.info(json);
				return list;
			}else{
				List<Map<String,Object>>  list =  JSON.parseObject(value,new TypeReference< List<Map<String,Object>>  >(){});  
				return list;
			}
			
		}catch(Exception e){
			logger.error("e:",e);
		}finally{
			long e = System.currentTimeMillis();
			logger.info("{}",(e-s));
			//System.out.println(e-s);
		}
		return null;
	}
	
	
	public List<Map<String,Object>> find(Integer no,Integer size){
		long s = System.currentTimeMillis();
		try{
			if(no == null || no < 1){
				no=1;
			}
			if(size == null || size < 1){
				size = 1;
			}
			Integer start = (no-1) * size;
			String sql = "select commercialID ID,commercialName,commercialAdress,commercialPhone from commercial limit "+start+","+size;
			List<Map<String,Object>> list = indexDao.find(sql);
			String json = JSON.toJSONString(list);
			logger.info(json);
			return list;
		}catch(Exception e){
			logger.error("e:",e);
		}finally{
			long e = System.currentTimeMillis();
			logger.info("{}",(e-s));
			//System.out.println(e-s);
			
		}
		return null;
	}
	
	private DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 发送消息
	 * @param size
	 */
	public String message(Integer size){
		if(size != null && size > 0){
			new Thread(new Runnable(){
				public void run() {
					for(int i=0; i< size;i++){
						testProducer.sendMessage(null);
						testProducer.sendMessageDelay(null);
					}
				}}).start();
			
		}else{
			testProducer.sendMessage(null);
			testProducer.sendMessageDelay(null);
		}
		
		return sdf.format(new Date());
	
	}
	
	public void get(String key) throws ExecutionException {
	/*	LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
			public String load(String key) throws Exception {
				String strProValue = "hello " + key + "!";
				return strProValue;
			}
		});
		 cahceBuilder.put("harry", "ssdded");*/

		 
	
	     /*   String resultVal = cache.get(key, new Callable<String>() {  
	            public String call() {  
	                return resultVal;
	            }  
	        });*/
	}
}
