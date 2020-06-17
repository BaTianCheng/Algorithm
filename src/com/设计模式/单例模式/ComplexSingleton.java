package com.设计模式.单例模式;

/**
 * 复杂单例模式，双层检测，可以多线程、懒加载，无法防止反射构建
 * @author wicks
 *
 */
public class ComplexSingleton {
    private ComplexSingleton() {}  //私有构造函数
    private volatile static ComplexSingleton instance = null;  //单例对象，volatile防止指令重排
    
    //静态工厂方法
    public static ComplexSingleton getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (ComplexSingleton.class) { // 同步锁
                if (instance == null) { // 双重检测机制
                    instance = new ComplexSingleton();
                }
            }
        }
        return instance;
    }

}
