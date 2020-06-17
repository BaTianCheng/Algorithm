package com.设计模式.原型模式;
import com.设计模式.原型模式.framework.*;

/**
 * manager作为管理器，根据不同的名称复制实例来创建实例
 * 好处是避免创建太多的类
 * 例如MessageBox的对象很多，无法整合到一个类里面（print*、print/），如果每个MessageBox都创建一个类，又太多了
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成
        Product p1 = manager.create("warning box");
        p1.use("Hello, world.");
        Product p2 = manager.create("slash box");
        p2.use("Hello, world.");
        Product p3 = manager.create("warning box");
        p3.use("AAAAAAAA.");
    }
}
