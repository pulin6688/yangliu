package com;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Resources;

public class Test {
	
 static Integer sum = 0;
 static  AtomicInteger atomicInteger = new AtomicInteger(0);
 static CountDownLatch latch = new CountDownLatch(10000);
 static ReentrantLock lock = new ReentrantLock();
 
 	public static boolean isOdd(int i){
 		System.out.println( i % 2 == 1);
 		return i % 2 == 1;
	 }
	
	public static void main(String[] args) throws Exception{
		
		 
	      InputStream is = Test.class.getClass().getResourceAsStream("/testclient.truststore");
	        try {
	        	  byte[] byt = new byte[8096];
	        	  int index=0;
	               while(is.read(byt,0,1)>=1){
	            	   index++;
	               }
	               
	               System.out.println("index:"+index);
	        	
	           // FileUtils.copyInputStreamToFile(is,new File(Resources.getResource("/").getPath()));
	            FileUtils.copyInputStreamToFile(is,new File("D:/testclient.truststore"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		System.out.println( (int) (char)(byte)-1);
		
		ExecutorService exec = Executors.newFixedThreadPool(100);
		Long s = System.currentTimeMillis();
		for(int i=1;i<=10000;i++){
			exec.submit(new Runnable(){
				public void run() {
					test2();
				}
			});
		}
		
		latch.await();
		Long e = System.currentTimeMillis();
		System.out.println(e-s);
		exec.shutdown();
		System.out.println(sum);
		System.out.println(atomicInteger);
	
	}
	
	public static void test(){
		atomicInteger.addAndGet(2);
		sum ++;
		latch.countDown();
	}
	
	public synchronized static void test2(){
		atomicInteger.addAndGet(2);
		sum ++;
		latch.countDown();
	}
	public static void test3(){
		try{
			lock.lock();
			atomicInteger.addAndGet(2);
			sum ++;
			latch.countDown();
		}finally{
			lock.unlock();
		}
		
	}

}
