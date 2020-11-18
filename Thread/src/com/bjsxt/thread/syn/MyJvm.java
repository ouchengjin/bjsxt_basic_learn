package com.bjsxt.thread.syn;
/**
 * 单例创建的方式
 * 1.懒汉式
 * 1）构造器私有化
 * 2）声明私有的静态属性
 * 3）对外提供访问静态属性的方法，确保该对象存在
 * @ClassName: MyJvm
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-13 20:13:43
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
	}
	public static MyJvm getInstance() {
		if(null==instance) {//提供效率
			synchronized(MyJvm.class) {
				if(null==instance) {//安全
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
	

}
/**
 * 饿汉式
 * 1.懒汉式
 * 1）构造器私有化
 * 2）声明私有的静态属性 同时创建该对象
 * 3）对外提供访问静态属性的方法
 * @ClassName: MyJvm2
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-13 21:17:38
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();//加载类时这个属性就会被初始化
	private MyJvm2() {
	}
	public static MyJvm2 getInstance() {
		return instance;
	}
	

}
/**
 * 类在使用的时候才加载，JVMholder延缓了加载时间
 * 加载MyJvm3，不一定加载JVMholder。用到的时候才会加载，比如调用getInstance时
 * @ClassName: MyJvm3
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-13 21:32:55
 */
class MyJvm3 {
	private static class JVMholder{
	private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3() {
	}
	public static MyJvm3 getInstance() {
		return JVMholder.instance;
	}
	

}

