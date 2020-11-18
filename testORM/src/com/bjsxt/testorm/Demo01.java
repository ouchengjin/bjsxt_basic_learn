package com.bjsxt.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[]封装一条记录
 * 使用List<Object[]>存储多条记录
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 21:11:49
 */
public class Demo01 {

	public static void main(String[] args) {
		Connection mysqlConn = JDBCUtil.getMysqlConn();
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;
		List<Object[]> objsList= new ArrayList<Object[]>();
		try {
			prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id >=?");
			prepareStatement.setObject(1, 1);
			executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				Object[] objs = new Object[3];//一个Object数组封装了一条记录的信息
//				System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
				objs[0]=executeQuery.getString(1);
				objs[1]=executeQuery.getDouble(2);
				objs[2]=executeQuery.getInt(3);
				objsList.add(objs);
			}
			for(Object[] objstemp:objsList) {
				System.out.println(""+objstemp[0]+objstemp[1]+objstemp[2]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
		}
		for(Object[] objstemp:objsList) {
			System.out.println(""+objstemp[0]+objstemp[1]+objstemp[2]);
		}

	}

}
