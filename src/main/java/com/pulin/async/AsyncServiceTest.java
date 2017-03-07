package com.pulin.async;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * 异步验劵 模拟
 * 
 * @author pul
 *
 */
public class AsyncServiceTest {
	private static Integer cpuNum = Runtime.getRuntime().availableProcessors();
	//static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
	private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, (cpuNum == null?2:cpuNum)*2, 3, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardOldestPolicy());
	static final ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);
	  
	  public static void main(String[] args)  throws Exception{
		  test();
	
	  }
	  
	  
	  public static void test(){
		  new Thread(new Runnable(){
				public void run() {
					try {
						
						while(true){
							Long num=System.currentTimeMillis();
							if(num%2==0){
								Thread.sleep((long)( (Math.random()*1000)+1000) );
							}else if(num%3==0){
								Thread.sleep((long)( (Math.random()*1000)+3000) );
							}else if(num%5==0){
								Thread.sleep((long)( (Math.random()*1000)+5000) );
							}else{
								Thread.sleep((long)( (Math.random()*500)) );
							}
							
							 exe();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}).start();
		 
		  //print();
	  }
	
	  
	  public static void exe(){
			new Thread(new Runnable(){
				public void run() {
					try {
						Long s = System.currentTimeMillis();
						List<Integer> list = Lists.newArrayList();
						for(int i=0;i<2;i++){
							Integer num = AsyncServiceTest.submit();
							list.add(num);
							
						}
						System.out.println(list.toString());
						Long e = System.currentTimeMillis();
						System.out.println("e-s:"+(e-s));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
			}).start();
			
	  }
	  
	  public static void print(){
			new Thread(new Runnable(){
				public void run() {
					while(true){
						System.out.println("queue.size():"+queue.size());
						System.out.println("threadPool.getPoolSize():"+threadPool.getPoolSize());
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
	  } 
	  
	  static Integer index = 1;
	  @SuppressWarnings({ "unchecked", "rawtypes"})
	  public static Integer submit() throws Exception{
		  Callable<Integer> callable = new Callable<Integer>() {
		        public Integer call() throws InterruptedException {
		        	Long sleep = 0L;
		        	for(int i=0;i<10;i++){
		        		sleep += (long)(Math.random()*100);
		        	}
		        	Thread.sleep(sleep);
		        	 return index++;
		        }
		  };
		  ListenableFuture future = service.submit(callable);
		  final ListenableFuture<Integer> transform = Futures.transformAsync(future,
				new AsyncFunction<Integer, Boolean>() {
			        public ListenableFuture apply(Integer res) throws Exception {
			        	return Futures.immediateFuture(res);
			        }
			 });
		 return transform.get();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  @SuppressWarnings({ "unchecked", "rawtypes"})
	  public static List<Integer> submitList(Integer num) throws Exception{
		  
		  List<ListenableFuture> list = Lists.newArrayList();
		  for(int i = 0;i < num;i++){
			  final Integer index = i;
			  
			  Callable callable = new Callable<Integer>() {
			        public Integer call() throws InterruptedException {
			        	Thread.sleep(10000);
			            return index;
			        }
			  };
			  
			  Runnable runnable = new Runnable(){
				public void run() {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}};
			  
			  ListenableFuture future = service.submit(runnable);
			  list.add(future);
		  }
	  
		ListenableFuture[] arr = new ListenableFuture[list.size()];
	    for(int i=0;i<list.size();i++){
	    	arr[i] = list.get(i);
	    }
	    
	   // final ListenableFuture allFutures = Futures.allAsList(arr);
	    final ListenableFuture allFutures = Futures.successfulAsList(arr);
	   

	    final ListenableFuture<List<Integer>> transform = Futures.transformAsync(
	    	allFutures,
	    	new AsyncFunction<List<Integer>, Boolean>() {
		        public ListenableFuture apply(List<Integer> results) throws Exception {
		        	return Futures.immediateFuture(results);
		        }
	    });

	    Futures.addCallback(transform, new FutureCallback<Object>() {
	        public void onSuccess(Object result) {
	           // System.out.println(result.getClass());
	           // System.out.printf("success with: %s%n", result);
	        }
	        public void onFailure(Throwable thrown) {
	           // System.out.printf("onFailure%s%n", thrown.getMessage());
	        }
	    });
	    
	   // Futures.catchingAsync(input, exceptionType, fallback)
	    
	    return transform.get();

	  }
	  
	  
	  
	  


}
