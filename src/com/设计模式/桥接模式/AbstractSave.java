package com.设计模式.桥接模式;
//抽象
public abstract class AbstractSave {
	ISaveData saveData;
	public AbstractSave(ISaveData saveData){
		this.saveData = saveData;
	}
	public abstract void save(Object data);
}
