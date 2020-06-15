package com.设计模式.适配器模式.使用委托的适配器;

/**
 * 适配器
 * 持有原始类，委托原始类进行适配实现
 * @author wicks
 *
 */
public class PrintBanner extends Print {
    private Banner banner;
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    public void printWeak() {
        banner.showWithParen();
    }
    public void printStrong() {
        banner.showWithAster();
    }
}
