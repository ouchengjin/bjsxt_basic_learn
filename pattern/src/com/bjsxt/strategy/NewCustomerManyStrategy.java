package com.bjsxt.strategy;

public class NewCustomerManyStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		System.out.println("打9折");
		return price*0.9;
	}

}
