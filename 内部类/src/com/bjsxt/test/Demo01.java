package com.bjsxt.test;
/**
 * 测试内部类
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-27 22:23:25
 */
public class Demo01 {
	
	public static void main(String[] args) {
		Demo01 s= new Demo01();
	}
//	静态内部类
	/*public protected default private*/ 
	static class staticNestClass{
	}
	//普通内部类(成员内部类)
	private class FieldInnerClass{
	}
	//匿名内部类
	//两个作用：定义了匿名内部类的类体；创建了匿名内部类的实例
	Runnable runnable=new Runnable() {
		public void run() {
			
		}
	};
	void sayHello() {
		//方法内部类（局部内部类）
		class fangfaneibulei{
		}
		//匿名内部类
		//两个作用：定义了匿名内部类的类体；创建了匿名内部类的实例
		Runnable runnable=new Runnable() {
			public void run() {
				
			}
		};
	}
}
