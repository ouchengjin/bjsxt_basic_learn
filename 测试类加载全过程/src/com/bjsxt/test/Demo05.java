package com.bjsxt.test;
/**
 * 线程上下文类加载器的测试
 * @ClassName: Demo05
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-27 22:04:23
 */
public class Demo05 {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader= Demo05.class.getClassLoader();
		System.out.println(loader);
		
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(contextClassLoader);
		
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("E:\\eclipse-workspace-bjsxt\\测试类加载全过程\\bin"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass("com.bjsxt.test.Demo05");
		System.out.println(loadClass);
		System.out.println(loadClass.getClassLoader());
		
		
		
	}

}
