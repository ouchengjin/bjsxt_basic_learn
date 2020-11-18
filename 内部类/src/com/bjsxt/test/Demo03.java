package com.bjsxt.test;

import java.util.Date;

public class Demo03 {

	public static void main(String[] args) {
//		fieldInnerClass a = new fieldInnerClass();//成员内部类不可直接创建
		Outer03.fieldInnerClass a = new Outer03().new fieldInnerClass();
		a.test();
	}
}

class Outer03{
	
	public /* static */ void ttt() {
//		外部类内部可以直接调用内部类，因为调用此方法时肯定有外部类对象
		fieldInnerClass a= new fieldInnerClass();
	}
	class fieldInnerClass{
		private int a=3;
		int b=10;
		//成员内部类不允许有静态变量，除非定义为final常量，并且只能是编译器可以确定的常量表达式
		static final int c=1;
//		static final Date d=new Date();//d为final常量,其后的表达式也要为常量（本例编译器确认不了）
		/*
		 * static void ss() {//成员内部类不允许有静态方法
		 * 
		 * }
		 */
		 void test() {
			System.out.println(a);
			//先有外部类对象，再有内部类对象
			System.out.println("内部类对象"+this);
			System.out.println("外部类对象"+Outer03.this);//引用了外部类对象
		}
	}
}