package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//测试使用JDBCUtil工具类来简化JDBC开发
public class Demo11 {

	public static void main(String[] args) {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("insert into t_user (username) values (?)");
			prepareStatement.setObject(1, "Alan");
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(prepareStatement, conn);
			
		}
		
	}

}
