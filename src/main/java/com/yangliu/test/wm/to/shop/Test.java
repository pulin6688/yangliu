package com.yangliu.test.wm.to.shop;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.yangliu.test.wm.utils.BuildDataUtils;

public class Test {
	
	public static void main(String[] args) throws Exception {
		String json = FileUtils.readFileToString(new File("D:/dada.txt"), "gbk");
		//System.out.println(json);
		CreateShopTO to = JSON.parseObject(json, CreateShopTO.class);
		System.out.println(JSON.toJSON(BuildDataUtils.buildShopMap(to)));
	}
	
	

}
