package com.pulin.async;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
/**
 * http://www.cnblogs.com/whitewolf/p/4113860.html
 * 异步并发操作测试
 * @author pul
 *
 */
@Service
public class AsyncService {
	
	  static  final Logger logger = LoggerFactory.getLogger(AsyncService.class);
	  static Integer cpuNum = Runtime.getRuntime().availableProcessors();
	 
	  //static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
	  //static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	  static BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();
	  static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, (cpuNum == null?2:cpuNum)*20, 30, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardOldestPolicy());
	  static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
	  
	  
	  public static void main(String[] args)  throws Exception{
		Long s = System.currentTimeMillis();
		List<Integer> list = new AsyncService().submit();
		System.out.println(list.toString());
		Long e = System.currentTimeMillis();
		System.out.println("total:"+(e-s));
	  }
	  
	
	  
	  
	  
	  
	  
	  
	  
	  @SuppressWarnings({ "unchecked", "rawtypes"})
	  public  List<Integer> submit() throws Exception{
		  
		  
		  Long s = System.currentTimeMillis();
		  
		  List<ListenableFuture> list = Lists.newArrayList();
		  for(int i = 0;i < 10;i++){
			  
			  final Integer index = i;
			  ListenableFuture future = service.submit(new Callable<Integer>() {
			        public Integer call() throws InterruptedException {
			        	
			        	
			       /* 	Thread.sleep(1000);
			            if(index==6 || index==9){
			            	Integer a = index/0;
			            }
			            return index;*/
			        	
			        	
			        	try{
			        		Thread.sleep(2000);
				            if(index==6 || index==9){
				            	Integer a = index/0;
				            }
				            return index;
			        	}catch(Exception e){
			        		return -100;
			        	}
			            
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
	    //final ListenableFuture allFutures = Futures.successfulAsList(arr);
	   

	    final ListenableFuture<List<Integer>> listenableFuture = Futures.transformAsync(allFutures,
	    	new AsyncFunction<List<Integer>, Boolean>() {
		        public ListenableFuture apply(List<Integer> results) throws Exception {
		        	return Futures.immediateFuture(results);
		        }
	    });

	    //添加回调
	    Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
	        public void onSuccess(Object result) {
	            System.out.println(result.getClass());
	            System.out.printf("success with: %s%n", result);
	        }
	        public void onFailure(Throwable thrown) {
	            System.out.printf("onFailure%s%n", thrown.getMessage());
	        }
	    });
	    
	   // Futures.catchingAsync(input, exceptionType, fallback)
	    
	    Long e = System.currentTimeMillis();
	    System.out.println("e-s:"+(e-s));
	    
	    Long s1 = System.currentTimeMillis();
	    List<Integer> results = listenableFuture.get(10000L,TimeUnit.MILLISECONDS);
	    Long e1 = System.currentTimeMillis();
	    System.out.println("e1-s1:"+(e1-s1));
	  
	    return results;

	  }
}
