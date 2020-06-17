package com.设计模式.策略模式;
//具体的执行人（又称为环境上下文）
public class SaveClient {
	private ISaveData saveData;
	public SaveClient(ISaveData saveData){
		this.saveData = saveData;
	}
	public void setSaveData(ISaveData saveData){
		this.saveData = saveData;
	}
	public void save(Object data){
		saveData.save(data);
	}
}
