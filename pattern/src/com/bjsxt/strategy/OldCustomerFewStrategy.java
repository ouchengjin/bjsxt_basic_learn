package com.bjsxt.strategy;

public class OldCustomerFewStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		System.out.println("打八五折");
		return price*0.85;
	}

}
