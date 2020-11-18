package com.bjsxt.thread.creat;

public class RabbitApp {

	//加上main共三条线程
	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		//调用start方法
		rab.start();//不要调用run方法，系统内部会自己去调run
//		rab.run();//由上到下顺序执行
//		tor.run();//由上到下顺序执行
		tor.start();
		for(int i =0;i<100;i++) {
			System.out.println("main "+i);
			
		}

	}

}
