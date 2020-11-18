package com.bjsxt.factory.simplefactory;
/**
 * 
 * @ClassName: Client01
 * @Description: 测试在没有工厂模式的情况下 
 * @author Alan Ouyang
 * @date 2020-05-30 20:50:27
 */
public class Client01 {//调用者

	public static void main(String[] args) {
		Car audi = new Audi();
		Car byd = new Byd();
		audi.run();
		byd.run();
		
	}

}
