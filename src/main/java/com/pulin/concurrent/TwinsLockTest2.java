package com.pulin.concurrent;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest2 {
	
	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		final Lock lock = new TwinsLock();

		class Worker extends Thread {
			public void run() {
				lock.lock();
				System.out.println(Thread.currentThread());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
		
		
		
		class WorkerSleepThreeSeconds extends Thread {
			public void run() {
				lock.lock();
				System.out.println(Thread.currentThread());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
		;

		new Worker().start();// Thread-0
		new Worker().start();// Thread-1
		Thread.sleep(100);
		new WorkerSleepThreeSeconds().start(); // Thread-2
		Thread.sleep(400);
		new Worker().start(); // Thread-3

	}
	
	
}

