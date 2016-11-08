package com.yangliu;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

public class Test {
	
	public static void main(String[] args) {
		String old = "http://img.waimai.baidu.com/pb/0eeedd705abd5471b740f97545f6498ff2";
		old = old.replaceAll("/","\\\\\\/") ;//将 / 替换为 \/
		System.out.println(old);
		old = old.replaceAll("\\\\/","/") ;//将 \/ 替换为 /
		System.out.println(old);
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
