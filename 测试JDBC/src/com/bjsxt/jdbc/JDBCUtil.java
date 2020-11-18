package com.bjsxt.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties pro; //可以帮助读取和处理资源文件中的信息
	static {//加载JDBCUtil类的时候调用，只会加载一次
		pro= new Properties();
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getMysqlConn() {
		Connection conn;
		try {
			Class.forName(pro.getProperty("mysqlDriver"));
			conn = DriverManager.getConnection(pro.getProperty("mysqlUrl"),pro.getProperty("mysqlUser"),pro.getProperty("mysqlPwd"));
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Connection getOracleConn() {
		Connection conn;
		try {
			Class.forName(pro.getProperty("oracleDriver"));
			conn = DriverManager.getConnection(pro.getProperty("oracleUrl"),pro.getProperty("oracleUser"),pro.getProperty("oraclePwd"));
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void close(ResultSet executeQuery,Statement statement,Connection conn) {
		try {
			if(executeQuery!=null) {
				executeQuery.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement,Connection conn) {
		
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
