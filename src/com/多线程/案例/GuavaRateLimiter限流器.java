package com.多线程.案例;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaRateLimiter限流器 {
    
    public static void main(String[] args) {
        // 每秒10个请求（本质是匀速）
        RateLimiter rateLimiter = RateLimiter.create(5);
        
        ExecutorService eService = Executors.newFixedThreadPool(100);
        long firstTime = System.currentTimeMillis();
        System.out.println(firstTime +"   firstTime");
        
        for(int i=0;i<20;i++) {
            // 线程启动前加上则进行限流
            rateLimiter.acquire();
            eService.execute(() -> {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println(endTime+"  endTime, "+(endTime-firstTime));
            });
        }
        
    }

}