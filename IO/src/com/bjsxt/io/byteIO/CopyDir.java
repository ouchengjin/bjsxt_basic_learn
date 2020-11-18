package com.bjsxt.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 文件复制copyFile
 * 文件夹 创建mkdirs()
 * 递归查找子孙级
 * @ClassName: copyDir
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-26 22:27:27
 */
public class CopyDir {

	public static void main(String[] args) {
		//源目录,若此处为文件，就会报错
		String srcPath= "D:/mycode/cp";
		
		//目标目录
		String destPath = "D:/mycode/cp/dir1";

		try {
			FileUtil.copyDir(srcPath, destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
