package com.设计模式.访问者模式;

/**
 * 接受访问者的元素接口
 * @author wicks
 *
 */
public interface Element {
    public abstract void accept(Visitor v);
}
