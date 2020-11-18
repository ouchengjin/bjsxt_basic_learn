package com.bjsxt.io.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {

	public static void main(String[] args) {
		test2();
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件操作失败");
		}
	}
	
	/**
	 * 创建删除文件
	 * @throws IOException 
	 * 
	 */
	public static void  test3() throws IOException {
		//createNewFile()不存在创建新文件，存在返回flase
		String path = "D:/mycode/200.jpg";
//		String path = "D:/mycode/con";
		File src = new File(path);
		if(!src.exists()) {
			boolean flag= src.createNewFile();
			System.out.println(flag?"成功":"失败");
			
		}
		//delete()删除文件
		boolean flag= src.delete();
		System.out.println(flag?"成功":"失败");
	
//		File.createTempFile(prefix, suffix)(前缀3个字节长，后缀默认.temp)默认临时空间
//		File.createTempFile(prefix, suffix, directory)(前缀3个字节长，后缀默认.temp，目录)
//		File.createTempFile("ocj", ".temp");
		File temp=File.createTempFile("ocj", ".temp",new File("D:/mycode/"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp.deleteOnExit();//退出即删除
		
	}
	/**
	 * 判断信息
	 * File对象可以表示文件和文件夹
	 * length()只能读取文件的长度，不能读取文件夹长度
	 * @Title: test2
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-22 22:24:46
	 */
	public static void test2() {
//		String path = "Welcome.txt";
		String path = "D:/mycode/Welcome.class";
		File src = new File(path);
		
		System.out.println("文件是否存在："+src.exists());
		//是否可写
		System.out.println("文件是否可写："+src.canWrite());
		System.out.println("===============================");
		//isFile()
		//isDirectory()
		if(src.isFile()) {
			System.out.println("文件");
		}else if(src.isDirectory()){
			System.out.println("文件夹");
		}else {
			System.out.println("文件不存在");
		}
		System.out.println("是否为绝对路径："+src.isAbsolute());
		System.out.println("长度（字节数）为："+src.length());
	}
	
	/**
	 * 
	 * @Title: test1
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-22 22:25:02
	 */
	public static void test1() {
//		File src = new File("D:/mycode/Welcome.class");
		//建立联系（存不存在不一定）
		File src = new File("Welcome.txt");
		System.out.println(src.getName());//返回名称
		System.out.println(src.getPath());//如果是绝对路径返回绝对路径，否则返回相对路径
		System.out.println(src.getAbsolutePath());// 返回绝对路径
		System.out.println(src.getParent());// 返回上一级路径,如果是相对，没有上一级，返回null
		
	}
}
