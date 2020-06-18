package com.设计模式.外观模式;

import com.设计模式.外观模式.pagemaker.PageMaker;

/**
 * 外观模式
 * PageMaker作为外观模式类，集成了Database、HtmlWriter类
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
