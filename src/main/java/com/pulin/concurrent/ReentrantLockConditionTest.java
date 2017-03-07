package com.pulin.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionTest {
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		t1(lock,condition);
		t2(lock,condition);
		
		
	
		
		
	}
	
	public static void t1(ReentrantLock lock,Condition condition){
		new Thread(new Runnable(){
			public void run() {
				lock.lock();
				System.out.println("t1拿到锁了");
				try {
					System.out.println("t1在等一个信号");
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
				
				
			}
		}).start();
	}
	
	public static void t2(ReentrantLock lock,Condition condition){
		new Thread(new Runnable(){
			public void run() {
				lock.lock();
				System.out.println("t2拿到锁了");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					System.out.println("t2执行完成任务=======");
					condition.signalAll();
					System.out.println("t2发送了一个信号");
					lock.unlock();
				}
				
			}
		}).start();
	}
}
