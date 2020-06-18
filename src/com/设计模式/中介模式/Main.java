package com.设计模式.中介模式;

/**
 * 中介模式
 * colleague作为组员，mediator作为中介，所有消息通过中介交流
 * @author wicks
 *
 */
public class Main {
    
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Nice to meet u.");
        colleague2.send("Nice to meet u too.");
    }

}
