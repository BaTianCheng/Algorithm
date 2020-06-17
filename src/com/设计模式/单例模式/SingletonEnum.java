package com.设计模式.单例模式;

/**
 * 枚举实现的单例，可以防止反射构建，但无法懒加载
 * @author wicks
 *
 */
public enum SingletonEnum {
    INSTANCE;
}
