package com.bjsxt.factory.factoryfield;

public class BenzFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Benz();
	}


}
