package com.bjsxt.io.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {

	public static void main(String[] args) {
		String str= "中国";
		byte[] data= str.getBytes();
		//字节数不完整，字节缺少，长度丢失
		System.out.println(new String(data,0,3));
		
	}
	
	/**
	 * 编码和解码字符集必须相同，否则乱码
	 * @Title: test1
	 * @Description: TODO(描述)
	 * @author author
	 * @throws UnsupportedEncodingException 
	 * @date 2020-03-29 17:24:25
	 */
	public static void test1() throws UnsupportedEncodingException {
		//解码byte--char
		String str= "中国";
		//编码char--->byte
		byte[] data= str.getBytes();
		//编码与解码的字符集相同
		System.out.println(new String(data));

		data= str.getBytes("gbk");//设定编码字符集
		//字符集不统一出现乱码
		System.out.println(new String(data,"utf-8"));
	}

}
