package com.设计模式.观察者模式;

/**
 * 观察者模式
 * 设置两个观察者，观察随机数生成器的变化
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
