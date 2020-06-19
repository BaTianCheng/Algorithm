package com.设计模式.代理;

/**
 * 打印实体类接口
 * @author wicks
 *
 */
public interface Printable {
    public abstract void setPrinterName(String name);   // 设置名字
    public abstract String getPrinterName();            // 获取名字
    public abstract void print(String string);          // 显示文字（打印输出）
}
