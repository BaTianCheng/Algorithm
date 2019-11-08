package com.设计模式.桥接模式;
//具体实现
public class SaveToDB implements ISaveData{
	@Override
	public void save(Object data) {
		System.out.println(data + " 存储到数据库");
	}
}
