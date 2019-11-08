package com.设计模式.访问者模式;
//VIP用户，具体元素
public class UserVIP implements User{
	String estimation;
	public UserVIP(String estimation){
		this.estimation = estimation;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	String getEstimation(){
		return estimation;
	}
}
