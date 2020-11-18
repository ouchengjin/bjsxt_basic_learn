package com.bjsxt.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试使用javabean封装一条记录
 * 使用List<javabean>存储多条记录(代码已删除)
 * 也可以使用map<key,javabean>存储多条记录
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 22:01:06
 */
public class Demo03 {
	//javabean
	public static void test01() {
		Connection mysqlConn = JDBCUtil.getMysqlConn();
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;
		Emp emp = null;
		try {
			prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id =?");
			prepareStatement.setObject(1, 1);
			executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
//				System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
				emp = new Emp(executeQuery.getString(1), executeQuery.getDouble(2), executeQuery.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
		}
		System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
		

	}
		//list(javabean)
		public static void test02() {
			Connection mysqlConn = JDBCUtil.getMysqlConn();
			PreparedStatement prepareStatement = null;
			ResultSet executeQuery = null;
			List<Emp> empList =new ArrayList<Emp>();
			try {
				prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id >=?");
				prepareStatement.setObject(1, 1);
				executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
//					System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
					Emp emp = new Emp(executeQuery.getString(1), executeQuery.getDouble(2), executeQuery.getInt(3));
					empList.add(emp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
			}
			//遍历这一行的多列的信息
			for(Emp empTemp:empList) {
				System.out.println(empTemp.getEmpname()+"--"+empTemp.getSalary()+"--"+empTemp.getAge());
			}

		}

		//map(javabean)
		public static void test03() {
			Connection mysqlConn = JDBCUtil.getMysqlConn();
			PreparedStatement prepareStatement = null;
			ResultSet executeQuery = null;
			Map<String, Emp> empmap =new HashMap<String, Emp>();
			try {
				prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id >=?");
				prepareStatement.setObject(1, 1);
				executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
//					System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
					Emp emp = new Emp(executeQuery.getString(1), executeQuery.getDouble(2), executeQuery.getInt(3));
					empmap.put(emp.getEmpname(), emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
			}
			
			//遍历这一行的多列的信息
			for(String empTemp:empmap.keySet()) {
				Emp emp = empmap.get(empTemp);
				System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
				
			}
			

		}

	public static void main(String[] args) {
		test03();
		
	}
		

}
