package com.yangliu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @author pul@shishike.com
 * http post 请求工具类
 */
public class HttpUtils {
	
	private static PoolingHttpClientConnectionManager cm;
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	private  static PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
		if (cm == null) {
			synchronized (HttpUtils.class) {
				cm = new PoolingHttpClientConnectionManager();
				cm.setMaxTotal(200);
				cm.setDefaultMaxPerRoute(200);
			}
		}
		return cm;
	}

	
	private static CloseableHttpClient getCloseableHttpClient() {
		return HttpClients.custom().setConnectionManager(getPoolingHttpClientConnectionManager()).build();
	}
	
	
	/**
	 * http post请求带二进制文件上传
	 * @param url
	 * @param token
	 * @param encoded
	 * @param isFieldName
	 * @param version
	 * @return
	 * @throws IOException
     * @throws HttpException
     */
	public static Map<String,Object> dianpingHttpPostPhoto(String url, Map<String,Object> map,String fileUrl) throws Exception {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CloseableHttpResponse downLoadResponse = null;
		CloseableHttpResponse uploadResponse = null;
		try{
			CloseableHttpClient httpClient = getCloseableHttpClient();
			HttpGet httpGet = new HttpGet(fileUrl);
			downLoadResponse = httpClient.execute(httpGet);
			HttpEntity getEntity = downLoadResponse.getEntity();
			InputStream is = getEntity.getContent();
			Header contentType = getEntity.getContentType();

			HttpPost httppost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();//设置请求和传输超时时间
			httppost.setConfig(requestConfig);

			HttpEntity entity = MultipartEntityBuilder.create()
			.addTextBody("name", "")
			.addBinaryBody("file", is, ContentType.create(contentType.getValue()), "file")
			.build();
			
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				map.get(key);
			}

			httppost.setEntity(entity);
			uploadResponse = httpClient.execute(httppost);
			int statusCode = uploadResponse.getStatusLine().getStatusCode();
			resultMap.put("code", statusCode);
			HttpEntity responseEntity = uploadResponse.getEntity();
			String responseStr = EntityUtils.toString(responseEntity, "UTF-8");
			resultMap.put("content", responseStr);
			return resultMap;
		}catch(Exception e){
			logger.error("e:",e);
		}finally{
			if(downLoadResponse != null){
				try {
					downLoadResponse.close();
				} catch (IOException e) {
					logger.error("e:",e);
				}
			}
			if(uploadResponse != null){
				try {
					uploadResponse.close();
				} catch (IOException e) {
					logger.error("e:",e);
				}
			}
		}
		
		return null;
	}

	
	/**
	 * @param url (请求的url)
	 * @param json 需要提交的json数据
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws HttpException
	 */
	public static String httppostJson(String url,String json)  throws Exception{
		CloseableHttpResponse response = null;
		try{
			if (StringUtils.isBlank(url)) {
				throw new IllegalArgumentException("请求参数有误,url不能为空");
			}
			if (StringUtils.isBlank(json)) {
				throw new IllegalArgumentException("请求参数有误,json不能为空");
			}
			CloseableHttpClient httpClient = getCloseableHttpClient();
			HttpPost httppost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();//设置请求和传输超时时间
			httppost.setConfig(requestConfig);
			HttpEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
			httppost.setEntity(entity);
			response = httpClient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();//http解析状态码 200表示成功，其他表示失败
			System.out.println("statusCode:"+statusCode);
			if(statusCode == 200){
				HttpEntity responseEntity = response.getEntity();
				String responseStr = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println(responseStr);
				return responseStr;	
			}
			return null;
		}catch(Exception e){
			logger.error("e:",e);
		}finally{
			if(response != null){
			   try {  
                    response.close();  
                } catch (IOException e) {  
                	logger.error("e:",e);
                }  
			}
		}
		
		return null;
	}
	
	
	
	
	public static String httppost(String url,Map<String, Object> data) throws Exception {
		CloseableHttpResponse response = null;
		try{
			if (StringUtils.isBlank(url)) {
				throw new IllegalArgumentException("请求参数有误,url不能为空");
			}
			CloseableHttpClient httpClient = getCloseableHttpClient();
			HttpPost httppost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();//设置请求和传输超时时间
			httppost.setConfig(requestConfig);
			if(data != null){
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				Iterator<String> keys = data.keySet().iterator();
				StringBuilder sb = new StringBuilder();
				while(keys.hasNext()){
					String key = keys.next();
					Object value = data.get(key);
					//logger.info(key+":"+value);
					
					if("".equals(value.toString())){
						sb.append(key).append("=");
					}else{
						sb.append(key).append("=").append(value);
					}
					sb.append("&");
					
					
					
					if(value instanceof String){
						//System.out.println(key+"="+value);
						
						NameValuePair param;
						if("".equals(value.toString())){
							 param = new BasicNameValuePair(key, "");
						}else{
							 param = new BasicNameValuePair(key, value.toString());
						}
						
						pairs.add(param);
					}else{
						//System.out.println(key+"="+JSON.toJSONString(value));
						NameValuePair param = new BasicNameValuePair(key, JSON.toJSONString(value));
						pairs.add(param);
					}
					
					
				}
				
				String nn = url+"?"+sb.toString();
				if(nn.endsWith("&")){
					nn = nn.substring(0, nn.lastIndexOf("&"));
				}
				
				System.out.println("url:     "+nn);
				
				//logger.info("httppostdata:"+sb.toString());
				HttpEntity entity = new UrlEncodedFormEntity(pairs, "UTF-8");
				//EntityUtils.toString(entity)
				httppost.setEntity(entity);
			}
			response = httpClient.execute(httppost);
			System.out.println("response:"+response);
			int statusCode = response.getStatusLine().getStatusCode();//http解析状态码 200表示成功，其他表示失败
			System.out.println("statusCode:"+statusCode);
			if(statusCode == 200){
				HttpEntity responseEntity = response.getEntity();
				String responseStr = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println(responseStr);
				return responseStr;	
			}
			return null;	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(response != null){
			   try {  
                    response.close();  
                } catch (IOException e) {
                	logger.error("e:",e);
                }  
			}
		}
		return null;
	}
	
	
	public static String httpget(String url) throws Exception {
		CloseableHttpResponse response = null;
		try{
			if (StringUtils.isBlank(url)) {
				throw new IllegalArgumentException("请求参数有误,url不能为空");
			}
			CloseableHttpClient httpClient = getCloseableHttpClient();
			HttpGet httpget = new HttpGet(url);
			
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();//设置请求和传输超时时间
			httpget.setConfig(requestConfig);
			response = httpClient.execute(httpget);
			int statusCode = response.getStatusLine().getStatusCode();//http解析状态码 200表示成功，其他表示失败
			if(statusCode == 200){
				HttpEntity responseEntity = response.getEntity();
				String responseStr = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println(responseStr);
				return responseStr;	
			}
			return null;	
		}catch(Exception e){
			logger.error("e:",e);
		}finally{
			if(response != null){
			   try {  
                    response.close();  
                } catch (IOException e) {
                	logger.error("e:",e);
                }  
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		httpget("http://localhost/aaa");
	}
	

}
