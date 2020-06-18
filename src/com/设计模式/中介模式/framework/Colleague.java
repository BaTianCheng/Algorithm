package com.设计模式.中介模式.framework;

/**
 * 组员基类
 * @author wicks
 *
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

}