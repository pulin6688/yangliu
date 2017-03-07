package com.pulin.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
	static ExecutorService service = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
		test();
	}
	
	
	
	public static void test() {
		
		final Lock lock = new TwinsLock();
		
		class Worker extends Thread {
			public void run() {
				while (true) {
					lock.lock();
					try {
						Thread.sleep(1000L);
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000L);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		}
		for (int i = 0; i < 10000; i++) {
			Worker w = new Worker();
			w.start();
		}
		
		
		
		
		service.submit(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(2000L);
						System.out.println();
					} catch (Exception ex) {

					}
				}
			}
			
		});
		

		
		
		
		
		
		
		
	}

}
