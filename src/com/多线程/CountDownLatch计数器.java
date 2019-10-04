package com.多线程;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch计数器 {
    
    public static void main(String[] args) throws InterruptedException {
        
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(()-> {
            try {
                System.out.println("thread1-start");
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }
            finally {
                System.out.println("thread1-end");
                latch.countDown();
            }
        });
        Thread thread2 = new Thread(()-> {
            try {
                System.out.println("thread2-start");
                Thread.sleep(500);
            }
            catch (Exception e) {

            }
            finally {
                System.out.println("thread2-end");
                latch.countDown();
            }
        });
        
        thread1.start();
        thread2.start();
        
        latch.await();
        System.out.println("全部完成");
        
    }

}
