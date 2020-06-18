package com.设计模式.中介模式;

import com.设计模式.中介模式.framework.Colleague;
import com.设计模式.中介模式.framework.Mediator;

public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事1得到消息：" + message);
    }

}