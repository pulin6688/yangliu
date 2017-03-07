package com.pulin.async;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Created by zhudan on 16/5/6.
 */
public class SimpleAsync {
    private ExecutorService normalService = Executors.newCachedThreadPool();
    private ListeningExecutorService service = MoreExecutors.listeningDecorator(normalService);
    public SimpleFutureCallback doAsync() {
        return new SimpleFutureCallback(service);
    }
}
