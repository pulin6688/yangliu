package com.pulin.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	//static ExecutorService exec = Executors.newFixedThreadPool(100);
	static CountDownLatch latch  = new CountDownLatch(100);
	static CountDownLatch colseLatch  = new CountDownLatch(10);

	public static void main(String[] args) throws Exception{
		 //aa();
		 bb();
	}
	
	public static void aa() throws Exception{
		 CountDownLatch latch  = new CountDownLatch(100);
		 CountDownLatch colseLatch  = new CountDownLatch(10);
		 
		 
		 new Thread(new Runnable(){
				public void run() {
					try {
						colseLatch.await();
						Thread.sleep(1000);
						System.out.println("complete.");
						//exec.shutdown();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}).start();
		
		
		//======================
		for(int i=1;i<=100;i++){
		/*	exec.submit(new Runnable(){
				public void run() {
					try{
						Random r = new Random();
						Thread.sleep(r.nextInt(3000));
						latch.countDown();
					}catch(Exception e){
						e.printStackTrace();
					}
				}});*/
			
			new Thread(new Runnable(){
				public void run() {
					try{
						Random r = new Random();
						Thread.sleep(r.nextInt(3000));
						latch.countDown();
					}catch(Exception e){
						e.printStackTrace();
					}
				}}).start();
		}
		
		
		//======================
		for(int i=1;i<=10;i++){
			final int index = i;
			new Thread(new Runnable(){
				public void run() {
					try {
						latch.await();
						colseLatch.countDown();
						System.out.println("ok"+index+"_"+Thread.currentThread().getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}}).start();
		}
		
		
		
	}
	
	
	
	public static void bb() throws Exception{
		 CountDownLatch latch  = new CountDownLatch(100);
		 CountDownLatch colseLatch  = new CountDownLatch(1);
		 
		 new Thread(new Runnable(){
				public void run() {
					try {
						colseLatch.await();
						Thread.sleep(1000);
						System.out.println("complete.");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}).start();
		
		
		//======================
		for(int i=1;i<=100;i++){
		/*	exec.submit(new Runnable(){
				public void run() {
					try{
						Random r = new Random();
						Thread.sleep(r.nextInt(3000));
						latch.countDown();
					}catch(Exception e){
						e.printStackTrace();
					}
				}});*/
			
			new Thread(new Runnable(){
				public void run() {
					try{
						Random r = new Random();
						Thread.sleep(r.nextInt(3000));
						latch.countDown();
					}catch(Exception e){
						e.printStackTrace();
					}
				}}).start();
		}
		
		
		//======================
		new Thread(new Runnable(){
			public void run() {
				try {
					latch.await();
					colseLatch.countDown();
					System.out.println("ok"+1+"_"+Thread.currentThread().getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}}).start();
		
		
		
	}
	


}
