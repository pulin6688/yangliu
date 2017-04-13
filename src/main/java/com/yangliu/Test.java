package com.yangliu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

public class Test {
	
	static Map<String,String> map = new HashMap<String,String>();
	static List<String> list = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) {
//		String old = "http://img.waimai.baidu.com/pb/0eeedd705abd5471b740f97545f6498ff2";
//		old = old.replaceAll("/","\\\\\\/") ;//将 / 替换为 \/
//		System.out.println(old);
//		old = old.replaceAll("\\\\/","/") ;//将 \/ 替换为 /
//		System.out.println(old);
		
//		Integer a =new Integer(1);
//		Integer b =new Integer(1);
//		int c=1000;
//		int d=1000;
//		System.out.println(a==b);
//		System.out.println(c==d);
//		System.out.println(a.intValue()==b.intValue());
		
//		int count=1;
//		for(int i=0;i<10;i++){
//			count=count++;
//		}
//		System.out.println(count);
		
		
		
//		long x=1000000L;
//		int y=100000;
//		System.out.println(x*y);
		
		
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(null);
//		for(Integer t : list){
//			System.out.println(t.intValue());
//		}
//		System.out.println(list);
		
		//s(new Long(10));
		
//		String kk = new String("kk");
//		kk=kk.intern();
//		//System.out.println(kk==kk.intern());
//		System.out.println(kk=="kk");
		for(int i=0;i<1000;i++){
			Runnable r = new Runnable(){
				public void run() {
					Long num=0L;
					while(true){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						num++;
						String s = "abcdefghijklmnopqrstuvwxyz"+num+"";
						//s.intern();
						//map.put(s, s);
						
						list.add(s);
					}
				}
			};
			
			new Thread(r).start();
		}
		
		
	
		
		
		
		
	}
	
	
	public static void s(long s){
		System.out.println(s+"long");
	}
	public static  void s(Long s){
		System.out.println(s+"Long");
	}
	
	
	
	
	
	
	
	static class Person{
		@SerializedName("name")
		@JSONField(name="name")
		private String name;
		@SerializedName("url")
		@JSONField(name="url")
		private String url;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}

}
