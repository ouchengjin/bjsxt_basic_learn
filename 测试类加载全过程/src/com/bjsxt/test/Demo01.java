package com.bjsxt.test;

public class Demo01 {

	static {
		System.out.println("静态初始化类Demo01");
		
	}
	public void test() {
		System.out.println(a);
		int b=2;//在同一个方法体内必须先定义再使用
		System.out.println(b);
	}
	private int a=1;//在非static中，变量定义先后顺序不影响函数调用

	public static void main(String[] args) throws ClassNotFoundException {
		//字节码加载到方法区后，Demo01/String/String/aaa/int/a/323432(都是符号引用，不能直接用),
		//+都是作为常量存在的,方法区中每个类都有一个常量池.符号引用经过解析后变成直接引用（赋予了地址）
//		String String ="aaa";
//		int a= 323432;
//		System.out.println("A前");
		//主动引用
//		A b= new A();
//		A b2= new A();//类加载和初始化只有一次，故本次不需加载
//		System.out.println(B.str);//调用静态成员会初始化该类
//		B.print();//调用静态方法会初始化该类
//		Class.forName("com.bjsxt.test.B");//反射调用会初始化该类
		//被动引用
//		System.out.println(A.num);//当访问静态域时，只有真正声明这个域的类才会被初始化（此处为A_father）
		A[] as= new A[10];//通过数组定义类引用，不会触发此类的初始化
		System.out.println(A.FF);//引用常量不会触发此类的初始化（常量在编译阶段就存入调用类的常量池里了）
		
		
	}
}

class A	extends A_father{
//	public static int num=1;
	public static final int FF=99;
	public static int width=100;//在static,必须先定义再使用。静态变量、静态域，field
	static {
		System.out.println("width:"+width);
		width=300;
		System.out.println("static块静态初始化类A,width:"+width);
		
	}
	
	public A() {
		System.out.println("创建A的对象");
	}
}

class A_father {
	public static int num=102;
	static {
		System.out.println("静态初始化类A_father");
	}
}

class B{
	public static String str="B的str";
	static {
		System.out.println("静态初始化类B");
	}
	
	public static void print() {
		System.out.println("print");
	}
}
