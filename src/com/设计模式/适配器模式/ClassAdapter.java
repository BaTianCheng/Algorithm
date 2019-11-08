package com.设计模式.适配器模式;
//类适配器
public class ClassAdapter extends Adaptee implements Target {
	@Override
	public void playFlac(Object src) {
		//可能需要对src作处理
		playMp3(src);
	}
}