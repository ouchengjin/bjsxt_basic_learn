package com.bjsxt.test;
/**
 * 测试简单的加密解密（去反）操作
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-26 21:56:39
 */
public class Demo04 {

	public static void main(String[] args) throws ClassNotFoundException {
//		//测试取反操作
//		int i=3;//00000011
//		System.out.println(Integer.toBinaryString(i^0xff));
		//加密后的class文件，正常的类加载器无法加载，报ClassFormatError
//		FileSystemClassLoader loader= new FileSystemClassLoader("d:/mycode/myjava");
//		Class<?> a=loader.loadClass("com.bjsxt.temp.HelloWorld");
//		System.out.println(a);
		
		DecrptClassLoader loader= new DecrptClassLoader("d:/mycode/myjava");
		//我是将加密后的HelloWorld.class文件复制到d:/mycode/myjava/com/bjsxt/test下
		Class<?> a=loader.loadClass("com.bjsxt.test.HelloWorld");//这里的字符串要和java文件中的:包名+类名一致
		System.out.println(a);
	}
}
