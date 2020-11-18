package com.bjsxt.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、建立联系   File对象   源头 目的地
2、选择流     
	 文件输入流  InputStream FileInputStream
	  文件输出流  OutputStream FileOutputStream
3、操作  :  拷贝
	 byte[] flush =new byte[1024]; 
	 int len =0;
	  while(-1!=(len=输入流.read(flush))){  
		 输出流.write(flush,0,len)
	  }
             输出流.flush
4、释放资源 :关闭 两个流
 * @ClassName: CopyFileDemo
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-26 21:09:59
 */
public class CopyFileDemo {

	public static void main(String[] args)  {
		String src = "D:/mycode/cp/";
		String dest = "D:/mycode/cp/1010.jpg";
		try {
			copyFile(src, dest);
		} catch (FileNotFoundException e) {
			System.out.println("文件打开失败");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("拷贝文件失败，或关闭流失败");
			e.printStackTrace();
		}
		
	}
	/**
	 * 文件的拷贝
	 * @param 源文件路径
	 * @param 目标文件路径
	 * @throws IOException
	 */
	public static void copyFile(String srcPath,String destPath) throws FileNotFoundException, IOException  {
		//1、建立联系 源（存在且为文件）+目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//2.选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		//3文件的拷贝，循环+读取+写出
		byte[] flush= new byte[1024];
		int len = 0;
		//读取
		while(-1!=(len = is.read(flush))) {
			//写出
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		//关闭流，一般先打开的后关闭
//		os.close();
//		is.close();
//		FileUtil.close(os,is);
		FileUtil.closeAll(os,is);
		
	}
	
	/**
	 * 	1.7新特性try-with-resource
	 * @Title: copyFile2
	 * @Description: TODO(描述)
	 * @param srcPath
	 * @param destPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @author author
	 * @date 2020-04-03 23:08:06
	 */
	public static void copyFile2(String srcPath,String destPath) throws FileNotFoundException, IOException  {
		//1、建立联系 源（存在且为文件）+目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//2.选择流
		//实际上编译后还是try-catch-finally
		try (
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		){
			//3文件的拷贝，循环+读取+写出
			byte[] flush= new byte[1024];
			int len = 0;
			//读取
			while(-1!=(len = is.read(flush))) {
				//写出
				os.write(flush, 0, len);
			}
			os.flush();//强制刷出
			//关闭流，一般先打开的后关闭
	//		os.close();
	//		is.close();
	//		FileUtil.close(os,is);
//			FileUtil.closeAll(os,is);
		}
	}

}
