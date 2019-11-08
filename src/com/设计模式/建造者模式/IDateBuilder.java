package com.设计模式.建造者模式;
//抽象生成器
public interface IDateBuilder {
	IDateBuilder buildDate(int y,int m,int d);
	String date();
}
