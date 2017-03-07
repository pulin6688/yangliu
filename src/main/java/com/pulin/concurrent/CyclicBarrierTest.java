package com.pulin.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	static ExecutorService exec = Executors.newFixedThreadPool(1000);
	static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	//static BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();
	static ThreadPoolExecutor service = new ThreadPoolExecutor(
			10, 
			1000, 
			30, 
			TimeUnit.SECONDS, 
			queue, 
			new ThreadFactory(){
				public Thread newThread(Runnable r) {
					Thread thread = new Thread(r);
					//thread.setName("CyclicBarrierTest");
					return thread;
				}
			},
			new ThreadPoolExecutor.DiscardOldestPolicy()
			);
	
	
	
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
		 public void run() {
			 //达到临界点，执行
			   System.out.println("到达临界点，执行下一步。"+Thread.currentThread().getName());
		   }		  
	});
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		for(int i=1;i<=200;i++){
			service.submit(new Runnable(){
				public void run() {
					test();
				}});
		}
		
		service.shutdown();
	
	}
	
	
	public  static void test(){
		try{
			cyclicBarrier.await();//让线程等待
		}catch(Exception e){
			
		}
		
	}
	


}
