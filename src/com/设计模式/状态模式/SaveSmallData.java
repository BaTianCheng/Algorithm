package com.设计模式.状态模式;
//具体状态
public enum SaveSmallData implements State{
	instance;
	@Override
	public void save(Object data) {
		System.out.println("保存到Redis:" + data);
	}
}
