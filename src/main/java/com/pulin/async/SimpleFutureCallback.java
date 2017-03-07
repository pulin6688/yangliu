package com.pulin.async;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by zhudan on 16/5/6.
 */
public class SimpleFutureCallback {

    private ListeningExecutorService executorService;
    private ListenableFuture<String> futureTask1 = null;
    private ListenableFuture<String> futureTask2 = null;
    private ListenableFuture<String> futureTask3 = null;

    public SimpleFutureCallback(ListeningExecutorService executorService){
        this.executorService = executorService;
    }

    public SimpleFutureCallback callbackTask1(String str){
        this.futureTask1 = this.executorService.submit(() -> {
            StopWatch sw = new StopWatch();
            sw.start();
            Thread.sleep(900);
            sw.stop();
            System.out.println(Thread.currentThread().getName() + " Time:" + sw.getTotalTimeMillis() + "   SimpleFutureCallback.callbackTask1: " + str);
            return "SimpleFutureCallback.callbackTask1";
        });

        return this;
    }
    public SimpleFutureCallback callbackTask2(String str){
        this.futureTask2 = this.executorService.submit(() -> {
            StopWatch sw = new StopWatch();
            sw.start();
            Thread.sleep(1200);
            sw.stop();
            System.out.println(Thread.currentThread().getName() + " Time:" + sw.getTotalTimeMillis() + "   SimpleFutureCallback.callbackTask2: " + str);
            return "SimpleFutureCallback.callbackTask2";
        });
        return this;
    }
    public SimpleFutureCallback callbackTask3(String str){
        this.futureTask3 = this.executorService.submit(() -> {
            StopWatch sw = new StopWatch();
            sw.start();
            Thread.sleep(500);
            sw.stop();
            System.out.println(Thread.currentThread().getName() + " Time:" + sw.getTotalTimeMillis() + "   SimpleFutureCallback.callbackTask3: " + str);
            return "SimpleFutureCallback.callbackTask3";
        });
        return this;
    }

    public String getFutureTask1() throws ExecutionException, InterruptedException {

        return futureTask1.get();
    }

    public String getFutureTask2() throws ExecutionException, InterruptedException {
        return futureTask2.get();
    }

    public String getFutureTask3() throws ExecutionException, InterruptedException {
        return futureTask3.get();
    }

    public List<String> getAllFutures() throws ExecutionException, InterruptedException {
        ListenableFuture<List<String>> listListenableFuture = Futures.allAsList(this.futureTask1, this.futureTask2, this.futureTask3);
        return listListenableFuture.get();
    }
}
