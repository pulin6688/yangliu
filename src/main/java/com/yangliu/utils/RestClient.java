package com.yangliu.utils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	 public static final String _KRY_GLOBAL_MSG_ID = "_kry_global_msg_id";
	    public static final String IDENTIFIER = "IDENTIFIER";

	    public RestClient() {
	    }

	    public static RestTemplate getClient() {
	        return RestTemplateWrapper.getClient();
	    }
	    

	    public static <T> T exchange(
	    		String url, 
	    		HttpMethod method, 
	    		HttpHeaders httpHeaders, 
	    		Object body, 
	    		Class<T> responseType, 
	    		Object... uriVariables
	    		) throws Exception {
	    	
		        try {
		        	
		            HttpEntity e = new HttpEntity(body, httpHeaders);
		           
		            e = convert(e);
		            
		            if(uriVariables.length == 1 && uriVariables[0] instanceof Map) {
		              
		            	Map _uriVariables = (Map)uriVariables[0];
		            	
		                return getClient().exchange(url, method, e, responseType, uriVariables).getBody();
		          
		            } else {
		            	
		                return getClient().exchange(url, method, e, responseType, uriVariables).getBody();
		            }
		            
		        } catch (Exception var8) {
		            throw new Exception(var8);
		        }
		        
	    }
	    
	    

	    public static String postJson(String url, String jsonBody) throws Exception {
	        return (String)exchange(url, HttpMethod.POST, buildBasicJSONHeaders(), jsonBody, String.class, new Object[0]);
	    }

	    public static String postForm(String url, Map<String, String> paramMap) throws Exception {
	        return (String)exchange(url, HttpMethod.POST, buildBasicFORMHeaders(), paramMap, String.class, new Object[0]);
	    }

	    public static String get(String url) throws Exception {
	        return (String)exchange(url, HttpMethod.GET, (HttpHeaders)null, (Object)null, String.class, new Object[0]);
	    }
	    
	    
	    

	    public static String put(String url) throws Exception {
	        return (String)exchange(url, HttpMethod.PUT, (HttpHeaders)null, (Object)null, String.class, new Object[0]);
	    }
	    
	    
	    

	    public static HttpHeaders buildBasicFORMHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	  
	        headers.set("_kry_global_msg_id", getKryGlobalMsgId());
	        return headers;
	    }

	    private static String getId(String s) {
	        return String.format("%s@", new Object[]{s});
	    }

	    public static String getKryGlobalMsgId() {
	        String kryGlobalMsgId = MDC.get("IDENTIFIER");
	        if(StringUtils.isBlank(kryGlobalMsgId)) {
	            kryGlobalMsgId = getId(UUID.randomUUID().toString());
	        } else {
	            kryGlobalMsgId = getId(String.valueOf(kryGlobalMsgId));
	        }

	        return kryGlobalMsgId;
	    }

	    public static HttpHeaders buildBasicJSONHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        headers.set("_kry_global_msg_id", getKryGlobalMsgId());
	        return headers;
	    }

	    public static HttpHeaders buildBasicHTMLHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.TEXT_HTML);
	        headers.set("_kry_global_msg_id", getKryGlobalMsgId());
	        return headers;
	    }
	    
	    
	    

	    private static HttpEntity<?> convert(HttpEntity<?> requestEntity) {
	        Object body = requestEntity.getBody();
	        HttpHeaders headers = requestEntity.getHeaders();
	        if(body == null) {
	            return requestEntity;
	        } else {
	            LinkedMultiValueMap formEntity;
	            String name;
	            if(body instanceof Map) {
	                formEntity = new LinkedMultiValueMap();
	                Map fields = (Map)body;
	                Iterator i = fields.keySet().iterator();

	                while(i.hasNext()) {
	                    name = (String)i.next();
	                    formEntity.add(name, fields.get(name).toString());
	                }

	                requestEntity = new HttpEntity(formEntity, headers);
	            }
	            
	            

	            if(headers != null && MediaType.APPLICATION_FORM_URLENCODED.equals(headers.getContentType())) {
	                if(body instanceof String) {
	                    return requestEntity;
	                } else if(body instanceof Collection) {
	                    return requestEntity;
	                } else if(body instanceof Map) {
	                    return requestEntity;
	                } else {
	                    formEntity = new LinkedMultiValueMap();
	                    Field[] var10 = body.getClass().getDeclaredFields();

	                    for(int var11 = 0; var11 < var10.length; ++var11) {
	                        name = var10[var11].getName();
	                        String value = null;

	                        try {
	                            value = BeanUtils.getProperty(body, name);
	                        } catch (Exception var9) {
	                            var9.printStackTrace();
	                        }

	                        formEntity.add(name, value);
	                    }

	                    return new HttpEntity(formEntity, headers);
	                }
	            } else {
	                return requestEntity;
	            }
	        }
	    }
}
