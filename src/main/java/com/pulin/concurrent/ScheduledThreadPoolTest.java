package com.pulin.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

	public static void main(String[] args) throws Exception{
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		service.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Long s = System.currentTimeMillis();
				System.out.println(s+"|a|"+sdf.format(new Date(s)));
				
			}}, 1, 2, TimeUnit.SECONDS);
		System.out.println("======================");
		
		
		service.scheduleWithFixedDelay(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Long s = System.currentTimeMillis();
				System.out.println(s+"|b|"+sdf.format(new Date(s)));
				
			}}, 1, 2, TimeUnit.SECONDS);
	
	}

}
