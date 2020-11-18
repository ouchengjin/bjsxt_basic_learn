package com.bjsxt.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * mkdir()创建目录，必须确保父目录存在。如果不存在，创建失败
 * mkdirs()创建目录，如果父目录链不存在一同创建
 * list()文件、目录字符串的表示形式
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-23 21:49:25
 */
public class Demo04 {
	
	public static void main(String[] args) {

		String path = "D:/mycode/cp";
		File src = new File(path);//文件夹
		if(src.isDirectory()) {//存在并且为目录
			System.out.println("=========子目录|文件名=============");
			String[] subnames= src.list();
			for(String temp:subnames) {
				System.out.println(temp);
			}
			System.out.println("=========子目录|文件file对象=============");
			File[] subFiles=src.listFiles();
			for(File temp :subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("=========子文件为.java的文件");
			//命令涉及模式
			subFiles=src.listFiles(new FilenameFilter() {
				
				@Override
				/**
				 * dir代表src
				 * @Title: accept
				 * @Description: TODO(描述)
				 * @param dir
				 * @param name
				 * @return 
				 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String) 
				 * @author author
				 * @date 2020-03-23 22:27:29
				 */
				public boolean accept(File dir, String name) {
					System.out.println(dir.getName());
					return new File(dir, name).isFile()&&name.endsWith(".java");
				}
			});
			for(File temp :subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
		}
	}
	
	public static void test1() {
//		String path = "D:/mycode/sahkdh";
		String path = "D:/mycode/cp/gsadgh";
		File src = new File(path);
//		src.mkdir();
		src.mkdirs();
	}

}
