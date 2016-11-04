package com.yangliu.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Test {
	public static void main(String[] args) throws Exception {
		
		List<String> list = FileUtils.readLines(new File("D:/code_pulin/yangliu/src/main/java/com/yangliu/test/dishs.txt"));
		Map<String,List<String>> map = Maps.newHashMap();
		for(String s:list){
			//System.out.println(s);
			String k[] = s.split("[\\s]+");
			//System.out.println(k[0]+","+k[1]);
			List<String> l = map.get(k[0]);
			if(l!= null){
				l.add(k[1]);
			}else{
				l = Lists.newArrayList();
				l.add(k[1]);
				map.put(k[0], l);
			}
		}
		
		Iterator<String> ite = map.keySet().iterator();
		while(ite.hasNext()){
			Map<String,Object> data = Maps.newHashMap();
			String key = ite.next();
			List<String> l = map.get(key);
			data.put("shopIdenty", key);
			data.put("dishShopIds", l);
			data.put("operation", 3);
			System.out.println(JSON.toJSON(data));
		}
	
	}

}
