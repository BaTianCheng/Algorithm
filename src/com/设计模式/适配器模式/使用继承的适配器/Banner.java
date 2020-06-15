package com.设计模式.适配器模式.使用继承的适配器;

/**
 * 原始的类
 * @author wicks
 *
 */
public class Banner {
    private String string;
    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
