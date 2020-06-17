package com.设计模式.原型模式.framework;
import java.lang.Cloneable;

/**
 * 符合原型模式的产品类
 * @author wicks
 *
 */
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClone();
}
