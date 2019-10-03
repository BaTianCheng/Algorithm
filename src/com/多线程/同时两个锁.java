package com.多线程;

import java.util.List;
import java.util.ArrayList;

public class 同时两个锁 {
    
    public static void main(String[] args) throws InterruptedException {
        //以银行转账为例，A转给B，A的余额减少，B的余额增加
        Account A = new Account(100);
        Account B = new Account(100);
        Account C = new Account(100);
        Account D = new Account(100);
        
        Thread threadA = new Thread(()->{System.out.println("A-B start");A.transfer(B, 50);System.out.println("A-B end");});
        Thread threadB = new Thread(()->{System.out.println("B-C start");B.transfer(C, 50);System.out.println("B-C end");});
        Thread threadC = new Thread(()->{System.out.println("C-D start");C.transfer(D, 50);System.out.println("C-D end");});
        threadA.start();
        threadB.start();
        threadC.start();
    
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println(A.getBalance());
        System.out.println(B.getBalance());
        System.out.println(C.getBalance());
        System.out.println(D.getBalance());
    }

}

/**
 * 银行账户
 * @author wicks
 *
 */
class Account {
    private int balance;
    
    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    
    //还有一种做法，给Account加上ID，每次先锁最小的ID
    
    /**
     * 转账
     * @param to
     * @param amount
     */
    public void transfer(Account to, int amount) {
       
        try {
            //可加超时时间
            Allocator.apply(this, to);
            synchronized (this) {
                synchronized(to) {
                    Thread.sleep(1000);
                    if(this.balance >= amount) {
                        this.balance -= amount;
                        to.balance += amount;
                    }
                }
            }
        }
        catch(Exception ex) {
            
        }
        finally {
            Allocator.free(this, to);
        }
        
    }
}

/**
 * 锁的管理者
 * @author wicks
 *
 */
class Allocator {
    private static List<Object> als = new ArrayList<>();
    
    /**
     * 申请锁
     * @param from
     * @param to
     * @return
     * @throws InterruptedException 
     */
    synchronized static void apply(Object from, Object to) throws InterruptedException {
        while(als.contains(from) || als.contains(to)) {
            Allocator.class.wait();
        }
    }
    
    /**
     * 释放锁
     * @param from
     * @param to
     * @return
     */
    synchronized static void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        Allocator.class.notifyAll();
    }
    
}