package com.yangliu.keruyun.datacount;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {
	
	public static void main(String[] args) throws Exception{
		List<String> list = FileUtils.readLines(new File("D:/code_pulin/yangliu/src/main/java/com/yangliu/keruyun/datacount/commercial.txt"));
		String in = list.toString().replace("[", "(").replace("]", ")");
		//System.out.println(in);
		
		String sql = "select a.id,a.payment_id,a.pay_mode_id,a.pay_mode_name,a.server_create_time from payment_item a inner join payment b on a.payment_id=b.id where a.shop_identy in "+in+" and  b.payment_type=1  and  a.pay_mode_id in (-23,-24) GROUP BY a.shop_identy";
	
		System.out.println(sql);
	
	}

}
