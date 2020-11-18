package com.bjsxt.bridge;

public class Client {
	public static void main(String[] args) {
		//销售联想台式机
		new Desktop2(new Lenovo2()).sale();
		//销售dell台式机
		new Desktop2(new Dell2()).sale();
		//销售神州笔记本
		new Laptop2(new Shenzhou2()).sale();
		
}
}
