package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 测试时间处理（java.sql.date,java.sql.timestamp），取出指定时间段的数据
 * @ClassName: Demo08
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-13 22:55:23
 */
public class Demo08 {
	/**
	 * 将字符串代表的日期转为long数字（格式"yyyy-MM-dd hh:mm:ss"）
	 * @Title: str2Date
	 * @Description: TODO(描述)
	 * @param date
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-14 11:39:22
	 */
	public static long str2Date(String date) {
		try {
			DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date parse = simpleDateFormat.parse(date);
			long time = parse.getTime();
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了socket对象，是一个远程的连接，比较耗时这是connection对象管理的一个要点！）
			//真正开发时，为了提高效率，都会使用连接池来管理连接对象
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc","root","123456");
			
			preparedStatement = conn.prepareStatement("select * from t_user where regTime>? and regTime<? order by regTime");
			preparedStatement.setObject(1, new Date(str2Date("2020-05-01 12:11:22")));
			preparedStatement.setObject(2, new Date(str2Date("2020-05-05 12:11:22")));
			
//			preparedStatement = conn.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
//			preparedStatement.setObject(1, new Timestamp(str2Date("2020-05-22 12:11:22")));
//			preparedStatement.setObject(2, new Timestamp(str2Date("2020-05-25 12:11:22")));
			
			executeQuery = preparedStatement.executeQuery();
			
			while(executeQuery.next()) {
				System.out.println(executeQuery.getInt("id")+"----------"+executeQuery.getString("username")+"----------"+executeQuery.getString("pwd")+"----------"+executeQuery.getDate("regTime")+"----------"+executeQuery.getTimestamp("lastLoginTime"));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//遵循：resultset，statement，connection的关闭顺序
			//不能将多个关闭代码放到一个try-catch中，会导致  一个错误引起接下来的关闭不了
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
