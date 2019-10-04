package com.多线程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLock乐观读 {

    //StampedLock支持乐观读、悲观读、写锁，但他只是读写锁功能的子集，不支持可重入，中断会有性能问题
    
}

/**
 * 缓存
 * @author wicks
 *
 * @param <K> 缓存KEY
 * @param <V> 缓存VALUE
 */
class StampedCache<K, V> {
    
    final Map<K, V> caches = new HashMap<>();
    final StampedLock stampedLock = new StampedLock();
    
    /**
     * 读缓存
     * @param key
     * @return
     */
    V get(K key) {
        long stamp = stampedLock.tryOptimisticRead();
        if(stampedLock.validate(stamp)) {
            return caches.get(key);
        } else {
            // 未通过乐观读校验，升级为悲观锁
            stamp = stampedLock.readLock();
            try {
                return caches.get(key);
            }
            finally {
                stampedLock.unlockRead(stamp);
            }
        }
       
    }
    
    /**
     * 写缓存
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value) {
        long stamp = stampedLock.writeLock();
        try {
            return caches.put(key, value);
        }
        finally {
            stampedLock.unlockWrite(stamp);
        }
    }
    
}
