package com.bjsxt.builder;

public interface AirShipBuilder {
	OrbitalModule buildOrbitalModule();
	Engine buildEngine();
	EscapeTower buildEscapeTower();
}
