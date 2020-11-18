package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试事务概念和用法
 * @ClassName: Demo06
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-13 21:54:24
 */
public class Demo06 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		PreparedStatement prepareStatement2=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			conn.setAutoCommit(false);//jdbc默认为true，自动提交事务
			
			prepareStatement = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			prepareStatement.setObject(1, "欧成金");
			prepareStatement.setObject(2, "123456");
			prepareStatement.execute();
			System.out.println("插入一个用户：欧成金");
			
			Thread.sleep(3000);
			prepareStatement2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");
			prepareStatement2.setObject(1, "奥巴马");
			prepareStatement2.setObject(2, "123456");
			prepareStatement2.execute();
			System.out.println("插入一个用户：奥巴马");
			
			conn.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("回滚");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//遵循：resultset，statement，connection的关闭顺序
			//不能将多个关闭代码放到一个try-catch中，会导致  一个错误引起接下来的关闭不了
			try {
				if(prepareStatement2!=null) {
					prepareStatement2.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
