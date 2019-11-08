package com.设计模式.外观模式;
//计算优惠
public class Discount {
	int getDiscount(String discountCode){
		return Math.abs(discountCode.hashCode())%3;
	}
}
