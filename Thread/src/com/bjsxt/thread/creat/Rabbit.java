package com.bjsxt.thread.creat;
/**
 * 模拟龟兔赛跑
 * 创建多线程，继承Thread类+重写run（）（线程体）
 * 使用线程：创建子类对象，调用  对象.start()线程启动
 * @ClassName: Rabbit
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-08 22:01:40
 */
public class Rabbit extends Thread {

	@Override
	public void run() {
		//线程体
		for(int i =0;i<100;i++) {
			System.out.println("rabbit had run "+i+"steps");
			
		}
	}


}
class Tortoise extends Thread {
	@Override
	public void run() {
		//线程体
		for(int i =0;i<100;i++) {
			System.out.println("tortoise had run "+i+"steps");
			
		}
	}
}
