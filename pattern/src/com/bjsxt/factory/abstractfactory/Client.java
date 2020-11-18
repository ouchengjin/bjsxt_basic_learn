package com.bjsxt.factory.abstractfactory;

public class Client {

	public static void main(String[] args) {
		CarFactory luxuryCarFactory = new LuxuryCarFactory();
		Engine creatEngine = luxuryCarFactory.creatEngine();
		Seat creatSeat = luxuryCarFactory.creatSeat();
		Tire creatTire = luxuryCarFactory.creatTire();
		
		creatEngine.start();
		creatEngine.run();
		creatSeat.massage();
		creatTire.revolve();
	}

}
