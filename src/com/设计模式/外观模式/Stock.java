package com.设计模式.外观模式;

import java.util.Random;
//库存子系统
public class Stock {
	boolean hasStock(String product){
		return new Random().nextInt(Math.abs(product.hashCode()))>0;//模拟是否还有库存
	}
}