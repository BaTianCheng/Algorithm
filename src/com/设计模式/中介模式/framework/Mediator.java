package com.设计模式.中介模式.framework;

/**
 * 中介基类
 * @author wicks
 *
 */
public abstract class Mediator {

    //抽象的发送消息方法
    public abstract void send(String message, Colleague colleague);
}
