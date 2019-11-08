package com.设计模式.装饰器模式;
//具体的被装饰者
public class PersistentUtil implements IPersistentUtil{
	@Override
	public void persistentMsg(String msg) {
		System.out.println(msg + " 存入文件");
	}
}