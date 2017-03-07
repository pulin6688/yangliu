package com.pulin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKMainTest {
	public static void main(String[] args) {  
		  
        String str = "四川省成都市华阳镇海昌极地海洋世界";
        str = "天台年123123abc";
        IKAnalysis(str);  
    }  
	
	
  
    public static List<String> IKAnalysis(String str) {  
        List<String> keywordList = new ArrayList<String>();  
        try {  
            byte[] bt = str.getBytes();  
            InputStream ip = new ByteArrayInputStream(bt);  
            Reader read = new InputStreamReader(ip);  
            IKSegmenter iks = new IKSegmenter(read,false);//true开启只能分词模式，如果不设置默认为false，也就是细粒度分割  
            Lexeme t;  
            while ((t = iks.next()) != null) {  
                keywordList.add(t.getLexemeText());
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }   
        
        
       /* for (int i = 0; i < keyWordList.size() - 1; i++) { 
            for (int j = keyWordList.size() - 1; j > i; j--) { 
                if (keyWordList.get(j).equals(keyWordList.get(i))) { 
                    keyWordList.remove(j); 
                } 
            } 
        } 
        Collections.sort(keyWordList, new Comparator<String>() { 
            @Override 
            public int compare(String o1, String o2) { 
                return o2.length() - o1.length(); 
            } 
        })*/  
        
        
        System.out.println(keywordList);  
        return keywordList;  
    }  
}
