package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组 节点流
 * 数组长度有限，数据量不会很大
 * 文件内容不用太大
 * 1.文件-程序-字节数组
 * 2.字节数组-程序-文件
 * @ClassName: ByteArrayDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-30 22:33:29
 */
public class ByteArrayDemo01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		read(write());
	}
	
	
	/**
	 * 输出流，和文件输出流有些不同，有新增方法，不能使用多态
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//目的地
		byte[] dest=null;
		//选择流 不同点
		ByteArrayOutputStream bo= new ByteArrayOutputStream();
		//操作写出
		String str= "操作和文件输入流一致write";
		byte[] by= str.getBytes();
		bo.write(by, 0, by.length);
		//获取数据
		dest= bo.toByteArray();
		//释放资源
		bo.close();
		return dest;
	}
	
	/**
	 * 输入流，操作和文件输入流一致
	 * 读取字节数组
	 * @Title: read
	 * @Description: TODO(描述)
	 * @author author
	 * @throws IOException 
	 * @date 2020-03-30 22:34:42
	 */
	public static void read(byte[] src) throws IOException {
		//数据源,想象成其他电脑上的东西
//		String msg= "操作和文件输入流一致";
//		byte[] src = msg.getBytes();
		//和外界不存在联系故，不检查异常
		//选择流
		InputStream is= new BufferedInputStream(new ByteArrayInputStream(src));
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}

}
