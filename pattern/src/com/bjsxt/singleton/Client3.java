package com.bjsxt.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @ClassName: Client3
 * @Description: 测试多线程环境下5种创建单例模式的效率
 * @author Alan Ouyang
 * @date 2020-05-30 17:31:24
 */
public class Client3 {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		int threadNum =10;
		CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		for(int i=0;i<threadNum;i++) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int j=0;j<1000000;j++) {
					Object o = SingletonDemo2./*instance*/getSingletonsemo1();
				}
				countDownLatch.countDown();//线程数减一
			}
		}).start();
		}
		countDownLatch.await();//main线程阻塞，直到计数器变为0，才会继续往下执行
		long endTime = System.currentTimeMillis();
		System.out.println("总耗时："+(endTime-startTime));
	}

}
