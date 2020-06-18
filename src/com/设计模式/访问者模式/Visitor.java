package com.设计模式.访问者模式;

/**
 * 访问者基类
 * @author wicks
 *
 */
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
