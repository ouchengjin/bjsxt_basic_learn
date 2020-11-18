package com.bjsxt.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级文件|目录的名称（绝对路劲）
 * listFiles()
 * 递归
 * static listRoots()根目录
 * @ClassName: Demo05
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-23 22:34:12
 */
public class Demo05 {
	
	public static void main(String[] args) {
		String path = "D:/mycode/cp";
		File src = new File(path);//文件夹
//		printName(src);
		
		File[] roots=File.listRoots();
		System.out.println(Arrays.deepToString(roots));
		for(File temp:roots) {
			printName(temp);
		}
	}

	/**
	 * 输出路径
	 * @Title: printName
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-23 22:37:36
	 */
	public static void printName(File src) {
		if(null==src||!src.exists()){
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) {
			for(File temp:src.listFiles()) {
				printName(temp);
			}
		}
	}
}
