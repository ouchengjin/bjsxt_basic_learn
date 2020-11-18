package com.bjsxt.factory.abstractfactory;

public class LuxuryCarFactory  implements CarFactory{

	@Override
	public Engine creatEngine() {
		// TODO Auto-generated method stub
		return new LuxuryEngine();
	}

	@Override
	public Seat creatSeat() {
		// TODO Auto-generated method stub
		return new LuxurySeat();
	}

	@Override
	public Tire creatTire() {
		// TODO Auto-generated method stub
		return new LuxuryTire();
	}



}
