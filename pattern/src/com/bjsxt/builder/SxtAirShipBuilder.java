package com.bjsxt.builder;

public class SxtAirShipBuilder implements AirShipBuilder{
	//Stringbuilder，以后学习xml解析中JDOM库中的类Dombuilder、SaxBuilder也用到了建造者模式
	@Override
	public OrbitalModule buildOrbitalModule() {
		System.out.println("建造尚学堂牌轨道舱");
		return new 	OrbitalModule("尚学堂牌轨道舱");
	}

	@Override
	public Engine buildEngine() {
		System.out.println("建造尚学堂牌发动机");
		return new Engine("尚学堂牌发动机");
	}

	@Override
	public EscapeTower buildEscapeTower() {
		System.out.println("建造尚学堂牌逃逸塔");
		return new EscapeTower("尚学堂牌逃逸塔");
	}

}
