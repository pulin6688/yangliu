package com.yangliu.jsoup;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

public class HtmlParseTest {
	public static void main(String[] args) throws Exception {
		String path = "D:/power-emailable-report.html";
		String html = FileUtils.readFileToString(new File(path), "utf-8");
		//System.out.println(html);
		
		String s = html.substring(html.indexOf("<head>"), html.indexOf("</head>")+7);
		System.out.println(s);
		
		
		
	}
	
	
	public static Document parseHtmlFromString() throws Exception{
		String path = "D:/power-emailable-report.html";
		String html = FileUtils.readFileToString(new File(path), "utf-8");
		Document doc = Jsoup.parse(html);
		return doc;
	}
	
	 /**
     * 注意：这是一个不安全的方法
     * 将String转换成Html片段,注意防止跨站脚本攻击
     * @return Element
     */
    public static Element parseHtmlFragmentFromStringNotSafe(){
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }
    
    /**
     * 这是一个安全的方法
     * 将String转换成Html片段,注意防止跨站脚本攻击
     * @return Element
     */
    public static Element parseHtmlFragmentFromStringSafe(){
        String html = "<div><p>Lorem ipsum.</p>";
        //白名单列表定义了哪些元素和属性可以通过清洁器，其他的元素和属性一律移除
        Whitelist wl=new Whitelist();
        //比较松散的过滤，包括
        //"a", "b", "blockquote", "br", "caption", "cite", "code", "col",
        //"colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6",
        //"i", "img", "li", "ol", "p", "pre", "q", "small", "strike", "strong",
        //"sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u",
        //"ul"
        Whitelist.relaxed();
        //没有任何标签，只有文本
        Whitelist.none();
        //常规的过滤器
        //"a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em",
        //"i", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub",
        //"sup", "u", "ul"
        Whitelist.basic();
        //常规的过滤器，多了一个img标签
        Whitelist.basicWithImages();
        //文本类型的标签
        //"b", "em", "i", "strong", "u"
        Whitelist.simpleText();
        //另外还可以自定义过滤规则,例如
        wl.addTags("a");
        //执行过滤
        Jsoup.clean(html, wl);
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }
}
