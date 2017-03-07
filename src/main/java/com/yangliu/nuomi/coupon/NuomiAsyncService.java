package com.yangliu.nuomi.coupon;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.yangliu.utils.HttpUtils;
/**
 * http://www.cnblogs.com/whitewolf/p/4113860.html
 * 异步验劵
 * @author pul
 *
 */
public class NuomiAsyncService {
	
	  private static  final Logger logger = LoggerFactory.getLogger(NuomiAsyncService.class);
	  private static Integer cpuNum = Runtime.getRuntime().availableProcessors();
	  private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, (cpuNum == null?2:cpuNum)*10, 15, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.DiscardOldestPolicy());
	  private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);

	  
	  public static void main(String[] args)  throws Exception{
		  List<String> codes = Lists.newArrayList();
		 /* codes.add("536394243882");
		  codes.add("535860209877");
		  codes.add("536568543073");
		  codes.add("602739970385");
		  codes.add("536345283819");
		  codes.add("602882114646");
		  codes.add("536588824593");
		  codes.add("536150447084");
		  codes.add("537242364487");
		  codes.add("535813120132");
		  codes.add("602180734424");
		  codes.add("601944034211");
		  codes.add("535923807152");
		  codes.add("602520293619");
		  codes.add("534936526833");*/
		  
//		  codes.add("601910533851");
//		  codes.add("536842903137");
//		  codes.add("602780757267");
//		  codes.add("601907475642");
     	  codes.add("603528412767");
		  
		  
		  buildAndExecute(codes);
		  
	  }
	  
	
	  
	
	  public static void buildAndExecute(List<String> codes) throws Exception{
		  List<Map<String,Object>>  params = Lists.newArrayList();
		  for(String code : codes){
			  String method = "nuomi.serviceCenter.cert.thirdpart.query";
				String appid = "yU4wrFj5bE";
				String token = "67ab1b83aa0e8c87d972e7364ac4c9e8";
				//String code = "603480417065";
				String email = "lalal@baidu.com";
				Map<String,Object>  param = BuildNuomiRequestUtil.build(method, appid, token, code, email);
				params.add(param);
		  }
		  submitBatch(params);
		  //submit(params);
			
		}
	  
	  /**
	   * 串行验劵
	   * @param params
	   * @return
	   * @throws Exception
	   */
	  public static List<Long> submit(List<Map<String,Object>>  params)throws Exception{
		  List<Long> list = Lists.newArrayList();
		  for(Map<String,Object> param : params){
			  String json = JSON.toJSONString(param);
			  //System.out.println(json);
			  String url = "http://testapi.nuomi.com/nop/server/rest";
			  Long s = System.currentTimeMillis();
			  HttpUtils.httppost(url, param); 
			  Long e = System.currentTimeMillis();
			  System.out.println(param.get("code")+",time:"+(e-s));
			  list.add(e-s);
		  }
		  Long all = 0L;
		  for(Long time : list){
			  all+=time;
		  }
		  System.out.println("====all:"+all);
		  return list;
	  }
	  
	  
	  
	  /**
	   * 并行验劵
	   * @param codes
	   * @throws Exception
	   */
	  @SuppressWarnings({ "unchecked", "rawtypes"})
	  public  static List<Long> submitBatch(List<Map<String,Object>>  params) throws Exception{
		  List<ListenableFuture> list = Lists.newArrayList();
		  for(Map<String,Object> param : params){
			  ListenableFuture future = service.submit(
				new Callable<Long>() {
			        public Long call() throws Exception {
			        	String json = JSON.toJSONString(param);
						//System.out.println(json);
						String url = "http://testapi.nuomi.com/nop/server/rest";
						Long s = System.currentTimeMillis();
						HttpUtils.httppost(url, param); 
						Long e = System.currentTimeMillis();
						System.out.println(param.get("code")+",time:"+(e-s));
						return (e-s);
			        }
				  }
				);
			  list.add(future); 
		  }
			 
	  
		ListenableFuture[] arr = new ListenableFuture[list.size()];
	    for(int i=0;i<list.size();i++){
	    	arr[i] = list.get(i);
	    }
	    
	    final ListenableFuture allFutures = Futures.allAsList(arr);
	   // final ListenableFuture allFutures = Futures.successfulAsList(arr);
	   
	    final ListenableFuture<List<Long>> transform = Futures.transformAsync(
	    	allFutures,
	    	new AsyncFunction<List<Long>, Boolean>() {
		        public ListenableFuture apply(List<Long> results) throws Exception {
		        	return Futures.immediateFuture(results);
		        }
	    });

	    Futures.addCallback(transform, new FutureCallback<Object>() {
	        public void onSuccess(Object result) {
	            System.out.println(result.getClass());
	            System.out.printf("success with: %s%n", result);
	        }
	        public void onFailure(Throwable thrown) {
	            System.out.printf("onFailure%s%n", thrown.getMessage());
	        }
	    });
	    
	   // Futures.catchingAsync(input, exceptionType, fallback)
	    Long s = System.currentTimeMillis();
	    List<Long> results = transform.get();
	    Long e = System.currentTimeMillis();
	    System.out.println("all_time:"+(e-s));
	    return results;

	  }
}
