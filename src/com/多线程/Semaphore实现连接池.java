package com.多线程;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import com.google.common.base.Function;

public class Semaphore实现连接池 {

    //Semaphore相比较lock，功能少，但支持多个线程访问临界区
   public static void main(String[] args) throws InterruptedException {
     ObjectPool<String, String> pool = new ObjectPool<String, String>(2, "资源A");
       
     for(int i=0;i<10;i++) {
         Thread thread = new Thread(()->{
             try {
                 pool.excute(t -> {
                     System.out.println(System.currentTimeMillis()+":"+t);
                     try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                     return t.toString();
                 });
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });
         thread.start();
     }
   }

}

/**
 * 连接池/线程池
 * @author wicks
 * @param <T>
 *
 */
class ObjectPool<T, R> {
    
    final List<T> pool;
    final Semaphore sem;
    
    /**
     * 构造函数
     * @param size 默认大小
     * @param t 默认内容
     */
    public ObjectPool(int size, T t) {
        pool = new Vector<T>();
        sem = new Semaphore(size);
        
        for(int i=0;i<size;i++) {
            pool.add(t);
        }
    }
    
    
    /**
     * 执行
     * @param func
     * @return
     * @throws InterruptedException
     */
    public R excute(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        
        try {
            t = pool.remove(0);
            return func.apply(t);
        }
        finally {
            pool.add(t);
            sem.release();
        }

    }

}