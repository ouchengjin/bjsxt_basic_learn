package com.bjsxt.factory.factoryfield;

public class AudiFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Audi();
	}


}
