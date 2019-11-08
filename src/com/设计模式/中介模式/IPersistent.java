package com.设计模式.中介模式;
//同事（接口）
public interface IPersistent {
	void getData(Object data);
	void getData(Object data,Midiator midiator);
	void saveData();
}