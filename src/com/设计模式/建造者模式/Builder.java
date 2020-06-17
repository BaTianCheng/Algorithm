package com.设计模式.建造者模式;

/**
 * 构建模式基类
 * @author wicks
 *
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
