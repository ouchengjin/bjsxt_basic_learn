package com.bjsxt.factory.abstractfactory;

public interface Tire {
	void revolve();
}

class LuxuryTire implements Tire{

	@Override
	public void revolve() {
		System.out.println("旋转不磨损");
		
	}
	
}
class LowTire implements Tire{
	
	@Override
	public void revolve() {
		System.out.println("旋转磨损");
		
	}
	
}