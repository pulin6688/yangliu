package com.pulin.async;

import java.util.concurrent.ExecutionException;

import org.springframework.util.StopWatch;

/**
 * Created by zhudan on 16/5/6.
 */

public class TestSimpleAsync {
   static SimpleAsync simpleAsync = new SimpleAsync();
   public static void run() throws ExecutionException, InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        SimpleFutureCallback simpleFutureCallback = 
        		simpleAsync.doAsync()
        		.callbackTask1("test1")
        		.callbackTask2("test2")
        		.callbackTask3("test3")
        		.callbackTask3("test4");
//        String futureTask1 = simpleFutureCallback.getFutureTask1();
//        String futureTask2 = simpleFutureCallback.getFutureTask2();
//        String futureTask3 = simpleFutureCallback.getFutureTask3();
        System.out.println(simpleFutureCallback.getAllFutures());
        sw.stop();
        //异步编程完成三个任务的时间>=三个任务中最耗时任务
        //同步编程完成三个人物的时间>=三个任务总耗时的和
        System.out.println("Total Time: " + sw.getTotalTimeMillis());
        System.out.println(simpleFutureCallback.getAllFutures());
    }
   
   
   
   public static void main(String[] args) throws Exception {
	   run();
   }
}
