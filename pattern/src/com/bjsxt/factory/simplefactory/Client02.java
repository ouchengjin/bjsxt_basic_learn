package com.bjsxt.factory.simplefactory;
/**
 * 简单工厂模式的情况下 
 * @ClassName: Client02
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-30 21:07:50
 */
public class Client02 {//调用者

	public static void main(String[] args) {
		Car audi = CarFactory.creatCar("奥迪");
		Car byd =  CarFactory.creatCar("比亚迪");
		audi.run();
		byd.run();
		
	}

}
