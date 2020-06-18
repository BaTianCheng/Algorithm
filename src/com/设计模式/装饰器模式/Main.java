package com.设计模式.装饰器模式;

/**
 * 装饰器模式
 * SideBorder对StringDisplay进行了装饰，即调用它的方法getRowText，在这个方法外部包装了一层
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new SideBorder(b1, '#');
        b1.show();
        b2.show();
        Display b3 = new SideBorder(new SideBorder(new StringDisplay("你好，世界。"),'*'),'/');
        b3.show();
    }
}
