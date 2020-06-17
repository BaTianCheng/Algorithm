package com.设计模式.策略模式;
/**
 * 策略模式
 * 统一的执行人，根据情况变换策略
 * @author wicks
 *
 */
public class Main {
	public static void main(String args[]){
		Object data = "数据";
		ISaveData saveData = new SaveToRedis();
		SaveClient client = new SaveClient(saveData);
		client.save(data);
		client.setSaveData(new SaveToFile());
		client.save(data);
	}
}