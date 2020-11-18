package com.bjsxt.strategy;

public class Client {

	public static void main(String[] args) {
		new Context(new NewCustomerFewStrategy()).getPrice(100);
		new Context(new NewCustomerManyStrategy()).getPrice(100);
		new Context(new OldCustomerFewStrategy()).getPrice(100);
		new Context(new OldCustomerManyStrategy()).getPrice(100);
	}

}
