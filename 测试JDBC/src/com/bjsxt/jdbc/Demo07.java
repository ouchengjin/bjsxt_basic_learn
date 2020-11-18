package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**测试java.sql.date,java.sql.timestamp
 * @ClassName: Demo07
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 11:09:59
 */
public class Demo07 {
	
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
			for(int i=0;i<1000;i++) {
				
				int random = 1000000000+new Random().nextInt(1000000000);
				int random2 = 1000000000+new Random().nextInt(1000000000);
				prepareStatement = conn.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?)");
				prepareStatement.setObject(1, "欧成金"+i);
				prepareStatement.setObject(2, "123456");
				prepareStatement.setObject(3, new Date(System.currentTimeMillis()-random-random2));
				//如果需要插入指定日期，可以用Calender，dateformat
				prepareStatement.setObject(4, new Timestamp(System.currentTimeMillis()-random2));
				prepareStatement.execute();
			}
			System.out.println("插入一个用户：欧成金");
			
			
			
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
		}finally {
			//遵循：resultset，statement，connection的关闭顺序
			//不能将多个关闭代码放到一个try-catch中，会导致  一个错误引起接下来的关闭不了
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
