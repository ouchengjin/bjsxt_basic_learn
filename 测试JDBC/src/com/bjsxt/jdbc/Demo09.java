package com.bjsxt.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试CLOB 文本大对象的使用
 * 将文件内容，字符串插入数据库CLOB字段，将CLOB字段取出的操作
 * @ClassName: Demo09
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 14:57:38
 */
public class Demo09 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		Reader characterStream = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			
//			preparedStatement = conn.prepareStatement("insert into t_user (username,myInfo) values (?,?)");
//			preparedStatement.setString(1, "Alan");
//			//将文本文件中的内容直接输入到数据库中
////			preparedStatement.setClob(2, new FileReader("D:\\mycode\\myjava\\HelloWorld.java"));
//			//将程序中的字符串输入到输入到数据库中的CLOB字段中
//			preparedStatement.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("我是欧成金".getBytes()))));
//			boolean execute = preparedStatement.execute();
			
			preparedStatement = conn.prepareStatement("select * from t_user where id = ?");
			preparedStatement.setInt(1, 24016);
			executeQuery = preparedStatement.executeQuery();
			
			
			while(executeQuery.next()) {
				Clob clob = executeQuery.getClob("myInfo");
				characterStream = clob.getCharacterStream();
				int temp;
				while((temp=characterStream.read())!=-1) {
					
					System.out.print((char)temp);
				}
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//遵循：resultset，statement，connection的关闭顺序
			//不能将多个关闭代码放到一个try-catch中，会导致  一个错误引起接下来的关闭不了
			try {
				if(characterStream!=null) {
					characterStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
