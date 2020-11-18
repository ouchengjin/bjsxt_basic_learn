package com.bjsxt.test;
/**
 * 测试自定义的FileSystemClassLoader
 * @ClassName: Demo03
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-26 21:12:32
 */
public class Demo03 {

	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader= new FileSystemClassLoader("d:/mycode/myjava");
		FileSystemClassLoader loader1= new FileSystemClassLoader("d:/mycode/myjava");
		
		Class<?> a=loader.loadClass("com.bjsxt.test.HelloWorld");
		Class<?> a1=loader.loadClass("com.bjsxt.test.HelloWorld");
		Class<?> a2=loader1.loadClass("com.bjsxt.test.HelloWorld");
		Class<?> a3=loader1.loadClass("java.lang.String");
		Class<?> a4=loader1.loadClass("com.bjsxt.test.Demo01");
		//
		System.out.println(a);
		//同一个类被一个类加载器加载两次，JVM认为是相同的类
		System.out.println(a.hashCode());System.out.println(a1.hashCode());
		//被两个类加载器加载的同一个类，JVM不认为是相同的类 
		System.out.println(a1.hashCode());System.out.println(a2.hashCode());
		
		System.out.println(a3.getClassLoader());//引导类加载器
		System.out.println(a2.getClassLoader());//自定义的类加载器
		System.out.println(a4.getClassLoader());//系统默认的类加载器AppClassLoader
	}
}
