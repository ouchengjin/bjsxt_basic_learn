package com.bjsxt.factory.simplefactory;

public class CarFactory2 {

	public static Car creatAudi(String type) {
		return new Audi();
	}
	public static Car creatByd(String type) {
		return new Byd();
	}	
}
