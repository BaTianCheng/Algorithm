package com.设计模式.桥接模式;

/**
 * 计数显示类，在显示类的基础上增加了计数功能
 * @author wicks
 *
 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times) {       // 循环显示times次
        for (int i = 0; i < times; i++) {
            print();
        }
    }
}
