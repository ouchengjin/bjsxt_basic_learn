package com.bjsxt.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二、写出文件
1、建立联系   File对象  目的地
2、选择流     文件输出流  OutputStream FileOutputStream
3、操作  :  write() +flush
4、释放资源 :关闭
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-24 21:39:07
 */
public class Demo02 {

	public static void main(String[] args) {
		//1、建立联系   File对象  目的地
		File dest=new File("D:/mycode/cp/test.txt"); 
		//2、选择流     文件输出流  OutputStream FileOutputStream
		OutputStream os = null;
		//以追加的的形式写出文件,必须为true，否则为覆盖
		try {
			os = new FileOutputStream(dest,true);
			String str= "bjsxt is very good\r\n";
			byte[] data =str.getBytes();
			os.write(data, 0,data.length );
			
			os.flush();//强制刷新出去，相当于将数据从管道挤出去
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			System.out.println("文件写出失败");
			e.printStackTrace();
		}finally {
			try {
				//4、释放资源 :关闭
				if (null != os) {
					os.close();
				} 
			} catch (Exception e2) {
				System.out.println("关闭输出流失败");
			}
		}
		

	}

}
