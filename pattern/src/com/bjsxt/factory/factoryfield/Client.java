package com.bjsxt.factory.factoryfield;

public class Client {

	public static void main(String[] args) {
		Car audi = new AudiFactory().creatCar();
		Car benz = new BenzFactory().creatCar();
		audi.run();
		benz.run();
 	}

}
