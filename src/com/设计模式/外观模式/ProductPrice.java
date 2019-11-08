package com.设计模式.外观模式;
//获取商品价格
public class ProductPrice {
	int getPrice(String product){
		return Math.abs(product.hashCode());//模拟获取商品价格
	}
}
