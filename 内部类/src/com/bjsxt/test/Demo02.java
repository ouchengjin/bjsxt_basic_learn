package com.bjsxt.test;

import com.bjsxt.test.Outer02.StaticInnerClass;

/**
 * 测试静态内部类的详细用法
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-28 21:03:05
 */
public class Demo02 {

	
	
	public static void main(String[] args) {
		//一般情况下用这种方法创建
		Outer02.StaticInnerClass b0= new Outer02.StaticInnerClass();
		//在不相关的类中，可以直接创建静态内部类的对象（不需要通过所在外部类）
		StaticInnerClass b = new StaticInnerClass();

	}

}

class Outer02{
	int c =3;
	static int d=5;
	
	void ttt() {
		StaticInnerClass a = new StaticInnerClass();
	}
	
	/* private */ static class StaticInnerClass{
		int a =3;
		static int b=5;
		public void test() {
			System.out.println(d);
//			System.out.println(c);静态内部类不能使用外部类的非静态成员
		}
	}
}
