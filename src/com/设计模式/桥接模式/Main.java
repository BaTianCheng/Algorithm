package com.设计模式.桥接模式;

/**
 * 桥接模式
 * 原本的Display声明了具备的功能，具体实现交给DisplayImpl来实现，StringDisplayImpl继承了DisplayImpl作为实际实现类
 * 现在需要增加计数功能，那么CountDisplay继承了Display，依然使用StringDisplayImpl作为实现类
 * 目标是新功能可以桥接在已有功能上，好处是增加功能时可以不修改已有实现类
 * 
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, China."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
