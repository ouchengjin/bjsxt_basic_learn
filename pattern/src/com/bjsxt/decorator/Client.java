package com.bjsxt.decorator;

public class Client {

	public static void main(String[] args) {
		Car car = new Car();
		SuperCar supercar = new SuperCar(car);
		supercar.move();
		System.out.println("######################");
		SwimCar swimcar = new SwimCar(car);
		swimcar.move();
		System.out.println("######################");
		FlyCar flycar = new FlyCar(swimcar);
		flycar.move();
	}

}
