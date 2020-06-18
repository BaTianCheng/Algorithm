package com.设计模式.备忘录模式.game;
import java.util.*;

public class Memento {
    int money;                              // 所持金钱
    ArrayList<String> fruits;                       // 当前获得的水果
    public int getMoney() {                 // 获取当前所持金钱（narrow interface）
        return money;
    }
    Memento(int money) {                    // 构造函数(wide interface)
        this.money = money;
        this.fruits = new ArrayList<String>();
    }
    void addFruit(String fruit) {           // 添加水果(wide interface)
        fruits.add(fruit);
    }
    List<String> getFruits() {                      // 获取当前所持所有水果（wide interface）
         return (List<String>)fruits.clone();
    }
}
