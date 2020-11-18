package com.bjsxt.test;
/**
 * 测试方法内部类（局部内部类）
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-28 21:55:56
 */
public class Demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer04 aa= new Outer04();
		aa.test();
	}

}

class Outer04{
	
	public void test() {
//		FieldInnerClass c =new FieldInnerClass();//要在声明后再使用这个类
		final int d=2;
		//方法内部类就相当于局部变量，public protected default private,不能修饰方法内部类
		class FieldInnerClass{
			int a =10;
//			static int b=1;//方法内部类只能定义非静态成员
			void testinner() {
				System.out.println(d+1);
			}
			
		}
		FieldInnerClass a =new FieldInnerClass();//方法内部类一般只在方法内部使用
		a.testinner();
	}
//	//方法内部类只在方法内可见
//	FieldInnerClass a =new FieldInnerClass();
	
}
