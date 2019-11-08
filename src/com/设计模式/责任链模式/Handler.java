package com.设计模式.责任链模式;
//处理者
public interface Handler {
	int handleRequest(int n);
	void setNextHandler(Handler next);
}
