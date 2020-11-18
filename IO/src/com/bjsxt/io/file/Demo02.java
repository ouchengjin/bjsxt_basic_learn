package com.bjsxt.io.file;

import java.io.File;

/**
 * 相对路径和绝对路径，构造File对象
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-22 20:03:33
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath= "D:/mycode";
		String name= "Welcome.class";
		//相对路径
		File src= new File(parentPath, name);
		src = new File(new File(parentPath), name);
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("D:/mycode/Welcome.class");
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符，以user.dir构建
		src= new File("test.txt");
		src= new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
}

}
