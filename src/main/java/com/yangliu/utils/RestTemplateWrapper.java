package com.yangliu.utils;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.facebook.presto.jdbc.internal.guava.collect.Lists;

public class RestTemplateWrapper {
	  	private static final Logger logger = LoggerFactory.getLogger(RestTemplateWrapper.class);
	  	
	    private static RestTemplate restTemplate;

	    private RestTemplateWrapper() {
	    	
	    }

	    public static RestTemplate getClient() {
	        return restTemplate;
	    }

	    static {
	    	
	        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(30L, TimeUnit.SECONDS);
	        pollingConnectionManager.setMaxTotal(500);
	        pollingConnectionManager.setDefaultMaxPerRoute(500);
	        HttpClientBuilder httpClientBuilder = HttpClients.custom();
	        httpClientBuilder.setConnectionManager(pollingConnectionManager);
	        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
	        httpClientBuilder.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE);
	      
	        List<BasicHeader> headers = Lists.newArrayList();
	        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
	        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
	        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"));
	        headers.add(new BasicHeader("Connection", "keep-alive"));
	        httpClientBuilder.setDefaultHeaders(headers);
	        
	        CloseableHttpClient httpClient = httpClientBuilder.build();
	        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
	        clientHttpRequestFactory.setConnectTimeout(30000);
	        clientHttpRequestFactory.setReadTimeout(30000);
	        clientHttpRequestFactory.setConnectionRequestTimeout(200);
	        clientHttpRequestFactory.setBufferRequestBody(false);
	        
	        
	        List<HttpMessageConverter<?>> messageConverters = Lists.newArrayList();
	        
	        //1
	        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//	        List<MediaType> supportedMediaTypes = Lists.newArrayList();
//	        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//	        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
	        messageConverters.add(stringHttpMessageConverter);
	        
	        
	        //2
	        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
	        formHttpMessageConverter.setCharset(Charset.forName("UTF-8"));
	        messageConverters.add(formHttpMessageConverter);
	       
	        
	        //3
	        messageConverters.add(new GsonHttpMessageConverter());
	        
	        
	        //4
	        messageConverters.add(new ByteArrayHttpMessageConverter());
	        
	        restTemplate = new RestTemplate(messageConverters);
	        
	        restTemplate.setRequestFactory(clientHttpRequestFactory);
	        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
	        logger.info("RestClient初始化完成");
	    }
}
