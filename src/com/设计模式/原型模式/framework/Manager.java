package com.设计模式.原型模式.framework;
import java.util.*;

/**
 * 管理器
 * @author wicks
 *
 */
public class Manager {
    private HashMap<String, Product> showcase = new HashMap<String, Product>();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }
    public Product create(String protoname) {
        Product p = (Product)showcase.get(protoname);
        return p.createClone();
    }
}
