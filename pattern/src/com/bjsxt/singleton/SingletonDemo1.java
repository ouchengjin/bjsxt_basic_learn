package com.bjsxt.singleton;
/**
 * 测试饿汉式单例模式
 * @ClassName: SingletonDemo1
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-29 22:43:37
 */
public class SingletonDemo1 {
	//类初始化时立即加载这个对象（没有延时加载的优势）
	private static SingletonDemo1 singletonsemo1= new SingletonDemo1();
	
	private SingletonDemo1() {
	}

	//因为上面加载类的时候时候是天然线程安全的，所以本方法不需要加同步synchronized
	public static  SingletonDemo1 getSingletonsemo1() {
		return singletonsemo1;
	}
	
}
