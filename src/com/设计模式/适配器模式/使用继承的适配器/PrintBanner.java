package com.设计模式.适配器模式.使用继承的适配器;

/**
 * 适配器
 * 针对原始类进行需求适配
 * @author wicks
 *
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }
    public void printWeak() {
        showWithParen();
    }
    public void printStrong() {
        showWithAster();
    }
}
