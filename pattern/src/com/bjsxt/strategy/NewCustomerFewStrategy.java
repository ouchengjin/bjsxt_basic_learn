package com.bjsxt.strategy;

public class NewCustomerFewStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		System.out.println("不打折，原价");
		return price;
	}

}
