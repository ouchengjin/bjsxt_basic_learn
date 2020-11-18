package com.bjsxt.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试BLOB 2进制大对象的使用
 * 将文件插入数据库BLOB字段，将BLOB字段取出的操作
 * @ClassName: Demo10
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 14:57:28
 */
public class Demo10 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			
			preparedStatement = conn.prepareStatement("insert into t_user (username,headImg) values (?,?)");
			preparedStatement.setString(1, "Alan");
			//将图片中的内容直接输入到数据库中
//			preparedStatement.setBlob(2, new FileInputStream("D:\\mycode\\100.jpg"));
//			boolean execute = preparedStatement.execute();
			
			preparedStatement = conn.prepareStatement("select * from t_user where id = ?");
			preparedStatement.setInt(1, 24017);
			executeQuery = preparedStatement.executeQuery();
			
			
			while(executeQuery.next()) {
				Blob blob = executeQuery.getBlob("headImg");
				is = blob.getBinaryStream();
				os = new FileOutputStream("D:\\mycode\\101.jpg");
				int temp;
				while((temp=is.read())!=-1) {
					os.write(temp);
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
				if(os!=null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(executeQuery!=null) {
					executeQuery.close();
				}
			} catch (SQLException e) {
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
