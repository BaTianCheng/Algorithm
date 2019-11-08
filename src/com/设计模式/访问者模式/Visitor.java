package com.设计模式.访问者模式;
//抽象访问者
public interface Visitor {
	void visit(UserVIP user);
	void visit(UserOrdinary user);
}