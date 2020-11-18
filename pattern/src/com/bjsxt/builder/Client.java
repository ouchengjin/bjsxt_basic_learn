package com.bjsxt.builder;

public class Client {

	public static void main(String[] args) {
		SxtAirShipBuilder builder= new SxtAirShipBuilder();
		SxtAirShipDirector dir= new SxtAirShipDirector(builder);
		AirShip airShip = dir.directAirShip();
		System.out.println(airShip.getEngine().getName());
		System.out.println(airShip.getEscapeTower().getName());
		System.out.println(airShip.getOrbitalModule().getName());
		airShip.launch();

	}

}
