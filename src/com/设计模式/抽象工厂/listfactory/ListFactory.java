package com.设计模式.抽象工厂.listfactory;
import com.设计模式.抽象工厂.factory.*;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
}
