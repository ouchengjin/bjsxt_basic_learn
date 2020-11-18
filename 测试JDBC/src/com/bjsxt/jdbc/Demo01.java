package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试和数据库建立连接
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-13 15:22:12
 */
public class Demo01 {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			long startTime = System.currentTimeMillis();
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			long endTime = System.currentTimeMillis();
			System.out.println(conn);
			System.out.println("建立连接，耗时："+(endTime-startTime)+"ms毫秒");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
