package com.设计模式.状态模式;
//具体状态
public enum SaveMiddleData implements ISaveData{
	instance;
	@Override
	public void save(Object data) {
		System.out.println("保存到Mysql:" + data);
	}
}
