package com.bjsxt.others.pro;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {
	
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
//		pro.load(Demo04.class.getResourceAsStream("/com/bjsxt/others/pro/db.properties"));
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bjsxt/others/pro/db.properties")) ;
		System.out.println(pro.getProperty("user", "bjsxt"));
	}

}
