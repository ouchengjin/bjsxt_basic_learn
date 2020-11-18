package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-13 18:49:39
 */
public class Demo05 {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet executeQuery = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			
			conn.setAutoCommit(false);//设为手动提交
			long startTime = System.currentTimeMillis();
			statement = conn.createStatement();
			
			for(int i=0;i<20000;i++) {
				statement.addBatch("insert into t_user (username,pwd,regTime) values ('Alan"+i+"',66666,now())");
			}
			
			statement.executeBatch();
			conn.commit();//提交事务
			long endTime = System.currentTimeMillis();
			System.out.println("插入20000条数据，耗时："+(endTime-startTime)+"ms毫秒");
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//遵循：resultset，statement，connection的关闭顺序
			//不能将多个关闭代码放到一个try-catch中，会导致  一个错误引起接下来的关闭不了
			try {
				if(executeQuery!=null) {
					executeQuery.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(statement!=null) {
					statement.close();
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
