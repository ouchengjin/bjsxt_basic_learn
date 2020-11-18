package com.bjsxt.io.file;

import java.io.File;

/**
 * 两个常量
 * 1.路径分隔符;
 * 2.文件分隔符/(windows)  /(linux等)
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-22 19:42:43
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径表示形式
		String path = "D:\\mycode\\Welcome.class";//(不推荐)
		path = "D:"+File.separator+"mycode"+File.separator+"Welcome.class";//(动态生成，跨平台)
		//推荐方式,先复制路径，再把\替换成/,可用其他平台
		path = "D:/mycode/Welcome.class";
	}

}
