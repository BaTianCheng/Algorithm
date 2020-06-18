package com.设计模式.观察者模式;

/**
 * 观察者，以数字显示
 * @author wicks
 *
 */
public class DigitObserver implements Observer {
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
