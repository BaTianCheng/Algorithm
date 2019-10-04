package com.多线程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock实现缓存 {

    //读写均加锁，性能不高
    
}

/**
 * 缓存
 * @author wicks
 *
 * @param <K> 缓存KEY
 * @param <V> 缓存VALUE
 */
class Cache<K, V> {
    
    final Map<K, V> caches = new HashMap<>();
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock readLock = readWriteLock.readLock();
    final Lock writeLock = readWriteLock.writeLock();
    
    /**
     * 读缓存
     * @param key
     * @return
     */
    V get(K key) {
        readLock.lock();
        try {
            return caches.get(key);
        }
        finally {
            readLock.unlock();
        }
    }
    
    /**
     * 写缓存
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value) {
        writeLock.lock();
        try {
            return caches.put(key, value);
        }
        finally {
            writeLock.unlock();
        }
    }
    
}
