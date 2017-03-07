package com.pulin.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
	
	
	static Integer sum = 0;
	
	public static void main(String[] args) throws Exception{
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<100;i++){
			service.submit(new Runnable(){
				public void run() {
					test();
				}
				
			});
			
//			new Thread(new Runnable(){
//				public void run() {
//					test();
//				}
//				
//			}).start();
		}
		
		Thread.sleep(2000L);
		System.out.println(sum);
		service.shutdown();
	
		
		
	}
	
	
	public static synchronized void test(){
		sum ++;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
	

	
	
	
}
