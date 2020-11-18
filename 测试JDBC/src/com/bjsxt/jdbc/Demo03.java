package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试PreparedStatement的基本用法
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-13 15:22:12
 */
public class Demo03 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
			prepareStatement = conn.prepareStatement(sql);
			
//			prepareStatement.setString(1, "欧成金");//参数索引是从1开始计算的，而不是0
//			prepareStatement.setString(2,"1231456");
//			prepareStatement.setDate(3, new Date(System.currentTimeMillis()));;
//			prepareStatement.execute();
			
			//也可以使用setObject方法处理参数
//			prepareStatement.setObject(1, "欧成金2");//参数索引是从1开始计算的，而不是0
//			prepareStatement.setObject(2,"1231456");
//			prepareStatement.setObject(3, new Date(System.currentTimeMillis()));;
//			prepareStatement.execute();
//			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStatement!=null) {
					prepareStatement.close();
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
