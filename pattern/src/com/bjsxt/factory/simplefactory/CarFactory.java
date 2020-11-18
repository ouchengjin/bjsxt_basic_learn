package com.bjsxt.factory.simplefactory;

public class CarFactory {

	public static Car creatCar(String type) {
		Car ret=null;
		if("奥迪".equals(type)) {
			ret= new Audi();
		}else if("比亚迪".equals(type)) {
			ret= new Byd();
		}
		return ret;
		
	}
}
