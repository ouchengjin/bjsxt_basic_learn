package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.文件-程序-字节数组
 * 文件输入流     字节数组输出流
 * 2.字节数组-程序-文件
 * 字节数组输入流 文件输出流
 * @ClassName: ByteArrayDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-31 21:43:06
 */
public class ByteArrayDemo02 {

	public static void main(String[] args) throws IOException {
		byte[] data = getByteFromFile("D:/mycode/cp/100.jpg");
		toFileFromArray(data, "D:/mycode/cp/array.jpg");
	}
	
	/**
	 *  2.字节数组-程序-文件
	 *  字节数组输入流 文件输出流
	 * @throws IOException 
	 */
	public static void toFileFromArray(byte[] src,String destPath) throws IOException {
		//创建源
		//目的地
		File dest=new File(destPath);
		
		//选择流 
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));
		//操作 不断读取字节数组
		byte[] flush = new byte[1024];
		int len = 0 ;
		while(-1!=(len = is.read(flush))) {
			//写到文件中
			os.write(flush, 0, len);
		}
//		os.write(src, 0, src.length);
		os.flush();
		os.close();
		is.close();
		
	}
	
	
	/**
	 * 1.文件-程序-字节数组
	 * @throws IOException 
	 */
	public static byte[] getByteFromFile(String srcPath) throws IOException {
		//创建文件源
		File src = new File(srcPath);
		
		//创建字节数组目的地
		byte[] dest=null;
		//选择流
		//文件输入流     
		InputStream is= new BufferedInputStream(new FileInputStream(src));
		//字节数组输出流,不能使用多态
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		//操作,不断获取文件写到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))) {
			//写到字节数组流中
			bo.write(flush, 0, len);
		}
		bo.flush();
		dest= bo.toByteArray();
		bo.close();
		is.close();
		
		return dest;
	}

}
