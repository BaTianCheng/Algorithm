package com.多线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Executor与线程池 {
    
    private static int CORE_POOL_SIZE = 5;
    private static int MAX_POOL_SIZE = 100;
    private static int KEEP_ALIVE_TIME = 10000;
    private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
    private static ThreadFactory threadFactory = new ThreadFactory() {
        private final AtomicInteger integer = new AtomicInteger();
        public Thread newThread(Runnable r) {
            return new Thread(r, "myThreadPool thread:" + integer.getAndIncrement());
        }
    };
    
    public static void main(String[] args) {
        
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, workQueue, threadFactory);
        
        threadPool.execute(()->{ System.out.println( threadPool.getActiveCount());});
       

    }

}
