package com.设计模式.策略模式;
//具体策略
public class SaveToRedis implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println("数据：" + data + " 保存到Redis");
	}
}