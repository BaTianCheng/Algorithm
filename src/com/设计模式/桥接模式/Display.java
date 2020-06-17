package com.设计模式.桥接模式;

/**
 * 显示类，作为功能层次，实际实现交给了实现类
 * @author wicks
 *
 */
public class Display {
    private DisplayImpl impl;
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void print() {
        impl.rawPrint();
    }

    public final void display() {
        print();                    
    }
}
