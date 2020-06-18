package com.设计模式.中介模式;

import com.设计模式.中介模式.framework.Colleague;
import com.设计模式.中介模式.framework.Mediator;

public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事2得到消息：" + message);
    }

}