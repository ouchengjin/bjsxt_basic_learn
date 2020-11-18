package com.bjsxt.io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 转换流，字节转为字符
 * 1.输出流 OutputStreamWriter
 * 2.输入流 InputstreamReader
 * 
 * @ClassName: ConvertDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-29 17:47:53
 */
public class ConvertDemo02 {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @throws IOException
	 * @author author
	 * @date 2020-03-30 21:35:43
	 */
	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("D:/mycode/cp/Demo03.java")),"utf-8"));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(
								new File("D:/mycode/cp/Demo04.java")),"utf-8"));
		String info= null;
		while(null!=(info=br.readLine())) {
			bw.write(info);
			bw.newLine();
			System.out.println(info);
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
