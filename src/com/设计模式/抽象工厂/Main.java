package com.设计模式.抽象工厂;

import com.设计模式.抽象工厂.factory.*;

/**
 * 抽象工厂，根据工厂名获取具体的工厂
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {

        String factoryName = "com.设计模式.抽象工厂.listfactory.ListFactory";
        
        Factory factory = Factory.getFactory(factoryName);

        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");
        
        System.out.println(people.makeHTML());
        System.out.println(gmw.makeHTML());
    }
}
