package com.bjsxt.others.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		
//		pro.load(new FileReader("E:\\test\\properties\\db.properties"));
		pro.load(new FileReader("src/com/bjsxt/others/pro/db.properties"));
		System.out.println(pro.getProperty("user", "bjsxt"));
	}

}
