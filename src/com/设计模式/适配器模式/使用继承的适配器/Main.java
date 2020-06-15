package com.设计模式.适配器模式.使用继承的适配器;

/**
 * 使用继承来实现的适配器
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
