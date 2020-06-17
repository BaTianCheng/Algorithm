package com.设计模式.工厂方法.idcard;
import com.设计模式.工厂方法.framework.*;
import java.util.*;

/**
 * ID卡工厂
 * @author wicks
 *
 */
public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<String>();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List<String> getOwners() {
        return owners;
    }
}
