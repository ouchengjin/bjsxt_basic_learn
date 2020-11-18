package com.bjsxt.others.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro =  new Properties();
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
//		pro.store(new FileOutputStream(new File("E:\\test\\properties\\db.properties")), "db����");
//		pro.storeToXML(new FileOutputStream(new File("E:\\test\\properties\\db.xml")), "db����");
		
//		pro.store(new FileOutputStream(new File("db.properties")), "db����");
		pro.store(new FileOutputStream(new File("src/com/bjsxt/others/pro/db.properties")), "db����");
	}

}
