package com.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.多线程.ext.CallableTask;


/**
 * future的线程池用法
 * @author wicks
 *
 */
public class FutrueExecutors {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 100);
        
        // CompletionService实现
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(task1);
        completionService.submit(task2);
        for(int i=0;i<2;i++) {
            System.out.println(completionService.take().get());
        }
        
        // CompletionService实现(超时)
        List<Future<String>> list = new ArrayList<>(); 
        list.add(completionService.submit(task1));
        list.add(completionService.submit(task2));
        for(int i=0;i<2;i++) {
            try {
                String result = completionService.poll(200, TimeUnit.MILLISECONDS).get();
                System.out.println(System.currentTimeMillis() + ":" + result);
            }
            catch(Exception ex) {
                
            }
        }
        for(int i=0;i<list.size();i++) {
            Future<String> future = list.get(i);
            if(!future.isCancelled() && !future.isDone()) {
                future.cancel(true);
            }
        }
        
        // 自建BlockingQueue队列
        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        executor.execute(()->{
            try {
                queue.put(future1.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.execute(()->{
            try {
                queue.put(future2.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        for(int i=0;i<2;i++) {
            System.out.println(queue.take());
        }
    }
    

}
