package com.设计模式.状态模式;
//环境（Context）
public class DataContext {
	private State saveData;
	public void save(String data){
		if(data.length()<1<<2) {
			saveData = SaveSmallData.instance;
		}
		else if(data.length()<1<<4) {
			saveData = SaveMiddleData.instance;
		}
		else {
			saveData = SaveBigData.instance;
		}
		saveData.save(data);
	}
}
