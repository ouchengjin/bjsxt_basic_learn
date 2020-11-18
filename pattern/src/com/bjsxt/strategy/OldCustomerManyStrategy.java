package com.bjsxt.strategy;

public class OldCustomerManyStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		System.out.println("打八折");
		return price*0.8;
	}

}
