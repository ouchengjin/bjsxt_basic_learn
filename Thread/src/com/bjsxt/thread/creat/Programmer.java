package com.bjsxt.thread.creat;
/**
 * 推荐Runable 创建线程
 * 1）避免单继承的局限性
 * 2）可以共享资源
 * 
 * 使用Runnable 创建线程
 * 1.类实现Runnable 接口+重写run方法--真实角色类
 * 2.启动多线程 使用静态代理
 *  1）创建真实角色
 *  2）创建代理角色+真实角色引用
 *  3）调用.start()启动线程
 * @ClassName: Programmer
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-09 22:06:02
 */
public class Programmer implements Runnable{

	@Override
	public void run() {

		for(int i =0;i<1000;i++) {
			System.out.println("一边敲代码");
		}
	}



}
