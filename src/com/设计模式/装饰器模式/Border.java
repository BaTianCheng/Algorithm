package com.设计模式.装饰器模式;

/**
 * 装饰器基类
 * @author wicks
 *
 */
public abstract class Border extends Display {
    protected Display display;          // 表示被装饰物
    protected Border(Display display) { // 在生成实例时通过参数指定被装饰物
        this.display = display;
    }
}
