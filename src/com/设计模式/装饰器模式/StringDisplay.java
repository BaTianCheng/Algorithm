package com.设计模式.装饰器模式;

/**
 * 字符串展示类
 * @author wicks
 *
 */
public class StringDisplay extends Display {
    private String string;                          // 要显示的字符串
    public StringDisplay(String string) {           // 通过参数传入要显示的字符串
        this.string = string;
    }
    public int getColumns() {                       // 字符数
        return string.getBytes().length;
    }
    public int getRows() {                          // 行数是1
        return 1;
    }
    public String getRowText(int row) {             // 仅当row为0时返回值
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
