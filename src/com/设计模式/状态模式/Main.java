package com.设计模式.状态模式;

/**
 * 状态模式
 * 根据不同的数字判断是不同状态，不同状态赋予不同的实例
 * @author wicks
 *
 */
public class Main {
	public static void main(String args[]){
		String smallData = "小数据";
		String middleData = "介于小数据和大数据之间的数据";
		String bifgData = "这里就假定这是一个很大很大很大的数据";
		DataContext saveDataContext = new DataContext();
		saveDataContext.save(smallData);
		saveDataContext.save(middleData);
		saveDataContext.save(bifgData);
	}
}