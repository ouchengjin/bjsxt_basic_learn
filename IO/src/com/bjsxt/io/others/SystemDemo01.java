package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 三个常量
 * 1.System.in 输入流 键盘输入
 * 2.System.out输出流 控制台输出
 * 3.System.err 和2只有打印颜色不同（在纯文本看不出效果，只有在工具里可以看出），其他相同
 * 
 * ==>重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in
 * FileDescriptor.out
 * FileDescriptor.err
 * @ClassName: SystemDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-04 16:45:35
 */
public class SystemDemo01 {

	public static void main(String[] args) throws FileNotFoundException {
//		test1();
//		test2();
		System.out.println("a");//控制台--》文件
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("D:/mycode/cp/system.txt"))),true));
		System.out.println("bbbb");
		System.out.println("test");
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("get out");
		
	}
	public static void test2() throws FileNotFoundException {
		// TODO Auto-generated method stub
//		test1();
		InputStream is = System.in;//键盘输入
		is= new BufferedInputStream(new FileInputStream("D:/mycode/cp/print.txt"));
		Scanner sc = new Scanner(is);
//		System.out.println("please input :");
		System.out.println(sc.nextLine());

	}
	public static void test1() {
		System.out.println("test");
		System.err.println("err");
	}

}
