package com.设计模式.抽象工厂.iterator;
//抽象产品
public interface IIterator<T> {
	boolean hasNext();
	Object next();
}