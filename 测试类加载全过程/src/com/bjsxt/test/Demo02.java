package com.bjsxt.test;

public class Demo02 {
	
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//因为使用原生代码编写的，所以java里获取不到，为null
		//加载JAVA_HOME/jre/lib/rt.jar包里的
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("##################################");
		String a="ouchengjin";
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
	}
}
