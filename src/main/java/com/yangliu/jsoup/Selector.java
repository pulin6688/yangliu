package com.yangliu.jsoup;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-4-2上午10:41:19
 * @描述 选择器 操作示例
 */
public class Selector {
	
	public static Document parseHtmlFromString() throws Exception{
		String path = "D:/power-emailable-report.html";
		String html = FileUtils.readFileToString(new File(path), "utf-8");
		Document doc = Jsoup.parse(html);
		return doc;
	}
	public static void main(String[] args) {
		Document doc;
		try {
			// 获取文档
			doc = parseHtmlFromString();
			//System.out.println(doc.head());
			Elements es = doc.getElementsByTag("table");
			System.out.println(es.size());
			System.out.println(es.get(0).html());
			//System.out.println(es.get(1).html());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
