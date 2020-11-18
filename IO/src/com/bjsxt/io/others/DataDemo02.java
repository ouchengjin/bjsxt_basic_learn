package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.crypto.Data;

/**
 * 数据类型（基本数据类型+字符串）处理流
 * 输入流 dDataInputStream
 * 输出流DataOutputStream
 * java.io.EOFException：已达到文件末尾，没有读取到相关内容
 * @ClassName: DataDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-01 22:14:39
 */
public class DataDemo02 {

	public static void main(String[] args) {
		try {
			byte[] data=write();
			System.out.println(data.length);//如果有长度说明写进去了
			read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 从文件读取数据+类型
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException {
		//创建源
		InputStream is = new ByteArrayInputStream(src);
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						is));
		//操作	读取的顺序和写出一致，必须存在才能读取
		//不一致，读出数据会出现问题
		double dob=dis.readDouble();
		long lo= dis.readLong();
		String str= dis.readUTF();
		
		dis.close();
		System.out.println(dob);
		System.out.println(lo);
		System.out.println(str);
		
	}
	
	
	/**
	 * 数据+类型输出到字节数组中
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//目标数组
		byte[] dest = null;
		double point=2.5;
		long num = 100L;
		String str= "数据类型";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
//		选择流DataOutputStream
		DataOutputStream dos= new DataOutputStream(new BufferedOutputStream(bos));
//		操作 写出的顺序，为读取做准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dest = bos.toByteArray();
		//释放资源
		bos.close();
		dos.close();
		return dest;
		
		
	}
}
