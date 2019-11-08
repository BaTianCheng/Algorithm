package com.设计模式.桥接模式;
//细化抽象
public class NetSave extends AbstractSave{
	public NetSave(ISaveData saveData) {
		super(saveData);
	}
	@Override
	public void save(Object data) {
		System.out.print("网络存储：");
		saveData.save(data);
	}
}