package com.设计模式.桥接模式;

/**
 * 字符串显示实现类，作为功能实现（仅基本功能）
 * @author wicks
 *
 */
public class StringDisplayImpl extends DisplayImpl {
    private String string;                              // 要显示的字符串
    private int width;                                  // 以字节单位计算出的字符串的宽度
    public StringDisplayImpl(String string) {           // 构造函数接收要显示的字符串string
        this.string = string;                           // 将它保存在字段中
        this.width = string.getBytes().length;          // 把字符串的宽度也保存在字段中，以供使用。
    }

    public void rawPrint() {
        printLine();
        System.out.println("|" + string + "|");         // 前后加上"|"并显示
        printLine();
    }

    private void printLine() {
        System.out.print("+");                          // 显示用来表示方框的角的"+"
        for (int i = 0; i < width; i++) {               // 显示width个"-"
            System.out.print("-");                      // 将其用作方框的边框
        }
        System.out.println("+");                        // 显示用来表示方框的角的"+"
    }
}
