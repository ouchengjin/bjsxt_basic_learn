package com.bjsxt.factory.abstractfactory;

public class LowCarFactory  implements CarFactory{

	@Override
	public Engine creatEngine() {
		// TODO Auto-generated method stub
		return new LowEngine();
	}

	@Override
	public Seat creatSeat() {
		// TODO Auto-generated method stub
		return new LowSeat();
	}

	@Override
	public Tire creatTire() {
		// TODO Auto-generated method stub
		return new LowTire();
	}



}
