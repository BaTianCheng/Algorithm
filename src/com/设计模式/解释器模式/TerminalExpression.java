package com.设计模式.解释器模式;

public class TerminalExpression extends AbstractExpression {
    @Override
    public void Interpret(Context context) {
        System.out.println("终端解释器");
    }
}
