package com.设计模式.抽象工厂.tablefactory;
import com.设计模式.抽象工厂.factory.*;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
}
