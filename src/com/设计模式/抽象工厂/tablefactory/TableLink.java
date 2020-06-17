package com.设计模式.抽象工厂.tablefactory;
import com.设计模式.抽象工厂.factory.*;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
