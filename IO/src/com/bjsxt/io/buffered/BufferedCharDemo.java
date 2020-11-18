package com.bjsxt.io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 字符缓冲流+新增方法（不能发生多态）
 * @ClassName: BufferedCharDemo
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-29 16:44:15
 */
public class BufferedCharDemo {

	public static void main(String[] args) {
		//创建源,仅限于字符的纯文本
		File src= new File("D:/mycode/cp/Demo03.java");
		File dest= new File("D:/mycode/cp/char.txt");
//		File src= new File("D:/mycode/cp/100.jpg");
//		File dest= new File("D:/mycode/cp/char.jpg");
		//选择流
		BufferedReader reader=null;
		BufferedWriter wr= null;
		try {
			reader= new BufferedReader(new FileReader(src));
			wr = new BufferedWriter(new FileWriter(dest));
			//读取操作
//			char[] flush= new char[1024];
//			int len = 0;
//			while(-1!=(len=reader.read(flush))) {
//				//字符数组转成字符串
//				String str= new String(flush,0,len);
//				wr.write(str, 0, len);
//			}
			//新增方法的操作
			String linecontent=null;
			while(null!=(linecontent=reader.readLine())) {
				wr.write(linecontent);
//				wr.append("\r\n");
				wr.newLine();//换行符号
			}
			wr.flush();//强制刷出
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			System.out.println("文件打开失败");
			e.printStackTrace();
		}finally {
			if (null!= reader) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("流关闭失败");
					e.printStackTrace();
				}
			}
			if (null != wr) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
