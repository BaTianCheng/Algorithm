package com.设计模式.代理;

/**
 * 代理模式
 * 先不生成具体实现类，等需要的时候生成具体实现类
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.print("Hello, world.");
    }
}
