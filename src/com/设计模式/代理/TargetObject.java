package com.设计模式.代理;
//具体对象
public class TargetObject implements AbstractObject {
	@Override
	public void method1() {
		System.out.println("具体对象的方法1");
	}
	@Override
	public int method2() {
		System.out.println("具体对象的方法2");
		return 0;
	}
	@Override
	public void method3() {
		System.out.println("具体对象的方法3");
	}
}
