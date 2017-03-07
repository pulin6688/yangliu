package com.pulin.concurrent;

import java.util.concurrent.Phaser;

public class PhaserTest {
	static Phaser phaser  = new Phaser(1);

	public static void main(String[] args) throws Exception{
		//phaser.register();
		//phaser.bulkRegister(10);
		//phaser.arriveAndDeregister();
		//System.out.println(phaser.getRegisteredParties());
		//System.out.println(phaser.getArrivedParties()+","+phaser.getUnarrivedParties());
		
//		for(int i=1;i<=20;i++){
//			aa();
//			bb();
//			all();
//			all();
//		}
		
		aa();
	}
	
	public static void aa() throws Exception{
		 new Thread(new Runnable(){
				public void run() {
					try {
						phaser.arrive();// +1
						Thread.sleep(1000);
						//System.out.println(phaser.getArrivedParties()+","+phaser.getUnarrivedParties());
						phaser.arriveAndAwaitAdvance();//到达屏障等待
						System.out.println("aa complete.");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						
					}
				}
			}).start();
		
	}
	
	
	
	public static void bb() throws Exception{
		 new Thread(new Runnable(){
				public void run() {
					try {
						
						Thread.sleep(2000);
						System.out.println(phaser.getPhase());//到达第几个屏障
						System.out.println(phaser.getArrivedParties()+","+phaser.getUnarrivedParties());
						phaser.arriveAndAwaitAdvance();//到达屏障等待
						System.out.println("bb complete.");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						//phaser.arrive();
					}
				}
			}).start();
		
	}
	
	public static void all() throws Exception{
		 new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(5000);
						//System.out.println(phaser.getPhase());
						System.out.println(phaser.getArrivedParties()+","+phaser.getUnarrivedParties());
						phaser.arriveAndAwaitAdvance();//到达屏障等待
						System.out.println("all complete.");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						//phaser.arrive();
					}
				}
			}).start();
		
	}
	


}
