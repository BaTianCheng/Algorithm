package com.设计模式.责任链模式;

/**
 * 责任链模式
 * Support为问题解决类，自己能解决的就解决了，否则丢给下一个人解决
 * 接收问题--->解决前N个问题--->解决奇数问题--->解决前M个问题
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        Support alice   = new NoSupport("Alice");
        Support bob     = new LimitSupport("Bob", 100);
        Support elmo    = new OddSupport("Elmo");
        Support fred    = new LimitSupport("Fred", 300);
        // 形成职责链
        alice.setNext(bob).setNext(elmo).setNext(fred);
        // 制造各种问题
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
