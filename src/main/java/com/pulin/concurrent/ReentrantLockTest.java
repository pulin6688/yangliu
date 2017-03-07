package com.pulin.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	static ReentrantLock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();
	static CountDownLatch latch = new CountDownLatch(100);
	static Integer sum = 0;
	
	public static void main(String[] args) throws Exception{
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		all(lock,condition);
		b(lock,condition);
		c(lock,condition);
		
	}
	
	

	public static void all(ReentrantLock lock,Condition condition){
		new Thread(new Runnable(){
			public void run() {
				try {
					lock.lock();
					System.out.println("ALL获取锁成功...");
					System.out.println("ALL等待执行的信号...");
					condition.await();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					System.out.println("ALL全部执行完成...");
					lock.unlock();
					System.out.println("ALL释放锁...");
				}
				
			}}).start();
	}
	
	public static void b(ReentrantLock lock,Condition condition){
		new Thread(new Runnable(){
			public void run() {
				try {
					lock.lock();
					System.out.println("b获取锁成功...");
					Thread.sleep(1000);
					condition.await();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					System.out.println("b执行完成...");
					condition.signalAll();
					System.out.println("b发送信号...");
					lock.unlock();
					System.out.println("b释放锁...");
				}
				
			}}).start();
	}
	
	public static void c(ReentrantLock lock,Condition condition){
		new Thread(new Runnable(){
			public void run() {
				try {
					lock.lock();
					System.out.println("c获取锁成功...");
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					System.out.println("c执行完成...");
					condition.signalAll();
					System.out.println("c发送信号...");
					lock.unlock();
					System.out.println("c释放锁...");
				}	
				
			}}).start();
	}
	
	
	
	public  static void test() throws Exception{
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		
		long s = System.currentTimeMillis();
		for(int i=1;i<=100;i++){
			service.submit(new Runnable(){
				public void run() {
					try{
						lock.lock();
						sum ++ ;
						latch.countDown();
					}catch(Exception e){
						
					}finally{
						lock.unlock();
					}
				}});
		}
		
		
		latch.await();
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		System.out.println(sum);
		service.shutdown();
		
	}
	


}
