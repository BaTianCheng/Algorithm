package com.设计模式.原型模式;
import com.设计模式.原型模式.framework.*;

/**
 * 原型产品----消息框
 * @author wicks
 *
 */
public class MessageBox implements Product {
    private char decochar;
    
    /**
     * 构造器
     * @param decochar
     */
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }
    
    /**
     * 使用消息框
     * @param s
     */
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " "  + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }
    
    /**
     * 创建复制类
     * @param s
     */
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
