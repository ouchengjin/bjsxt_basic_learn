package com.bjsxt.io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节流文件拷贝+缓冲流，提高性能
 * 缓冲流（字节流）
 * @ClassName: BufferedByteDemo
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-29 16:21:49
 */
public class BufferedByteDemo {

	public static void main(String[] args) {
		try {
			copyFile("", "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		InputStream is = new BufferedInputStream(new  FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
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
		os.close();
		is.close();
		
	}
}
