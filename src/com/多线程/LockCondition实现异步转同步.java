package com.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition实现异步转同步 {
    
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private String result = null;
    
    /**
     * 获取结果
     * @param time
     * @return
     * @throws Exception 
     */
    public Object get(long timeout) throws Exception {
        long sTime = System.currentTimeMillis();
        lock.lock();
        try {
            while(result == null) {
                done.await(timeout, TimeUnit.MILLISECONDS);  //await时锁会释放
                if(result != null || System.currentTimeMillis() - sTime > timeout) {
                    break;
                }
            }
        } 
        finally {
            //缺少一个超时的处理
            lock.unlock();
        }
        return result;
    }
    
    /**
     * 当返回结果时，调用该方法
     */
    public void doRecevice(String response) {
        lock.lock();
        try {
            result = response;
            done.signal();
        }
        finally {
            lock.unlock();
        }
    }

}
