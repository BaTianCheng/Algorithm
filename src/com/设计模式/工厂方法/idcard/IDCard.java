package com.设计模式.工厂方法.idcard;
import com.设计模式.工厂方法.framework.*;

/**
 * ID卡产品
 * @author wicks
 *
 */
public class IDCard extends Product {
    private String owner;
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }
    public void use() {
        System.out.println("使用" + owner + "的ID卡。");
    }
    public String getOwner() {
        return owner;
    }
}
