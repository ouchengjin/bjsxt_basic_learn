package com.bjsxt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 * @ClassName: EncrptUtil
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-26 22:04:26
 */
public class EncrptUtil {
	
	public static void main(String[] args) {
		encrpt("D:\\mycode\\myjava\\com\\bjsxt\\test\\HelloWorld.class","D:\\mycode\\myjava\\com\\bjsxt\\temp\\HelloWorld.class");
	}

	public static void encrpt(String src,String dest) {
		FileInputStream fis=null;
		FileOutputStream fos =null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int content =-1;
			while((content=fis.read())!=-1) {
				System.out.println(content);
				System.out.println(content^0xff);
				
				fos.write(content^0xff);//取反操作 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fis != null) {
					fis.close();
				} 
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (fos != null) {
					fos.close();
				} 
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
}
