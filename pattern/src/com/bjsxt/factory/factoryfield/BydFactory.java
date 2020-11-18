package com.bjsxt.factory.factoryfield;

public class BydFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Byd();
	}


}
