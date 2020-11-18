package com.bjsxt.singleton;
/**
 * 测试懒汉式单例模式
 * @ClassName: SingletonDemo2
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-29 22:53:45
 */
public class SingletonDemo2 {
	//类初始化时不初始化这个对象（延时加载，真正用的时候再加载）
	private static SingletonDemo2 singletonsemo2;
	//私有化构造器
	private SingletonDemo2() {
	}

	//方法同步，调用效率低
	public  static synchronized SingletonDemo2 getSingletonsemo1() {
		if(singletonsemo2==null) {
			singletonsemo2= new SingletonDemo2();
		}
		return singletonsemo2;
	}
	
}
