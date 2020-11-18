package com.bjsxt.singleton;
/**
 * 测试静态内部类实现单例模式
 * @ClassName: SingletonDemo4
 * @Description: 线程安全，调用效率高，延时加载
 * @author Alan Ouyang
 * @date 2020-05-30 16:10:22
 */
public class SingletonDemo4 {
	private static class SingletonClassInstance {
		//final可加可不加
		private static /* final */ SingletonDemo4 singletonsemo1= new SingletonDemo4();
		
	}
	
	private SingletonDemo4() {
	}

	//因为上面加载类的时候时候是天然线程安全的，所以本方法不需要加同步synchronized
	public static  SingletonDemo4 getSingletonsemo1() {
		return SingletonClassInstance.singletonsemo1;
	}
	
}
