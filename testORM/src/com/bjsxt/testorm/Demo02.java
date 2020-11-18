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
 * * 测试使用map封装一条记录
 * 使用List<map>存储多条记录(代码已删除)
 * 使用map<map>存储多条记录
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-14 22:01:06
 */
public class Demo02 {
	//map(map)
	public static void test01() {
		Connection mysqlConn = JDBCUtil.getMysqlConn();
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;
		Map<String,Map<String, Object>> objmapMap =new HashMap<String, Map<String,Object>>();
		try {
			prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id >=?");
			prepareStatement.setObject(1, 1);
			executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				Map<String, Object> objmap= new HashMap<String, Object>();
//				System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
				objmap.put("empname", executeQuery.getString(1));
				objmap.put("salary", executeQuery.getDouble(2));
				objmap.put("age", executeQuery.getInt(3));
				objmapMap.put(executeQuery.getString("empname"), objmap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
		}
		for(String key:objmapMap.keySet()) {
			Map<String, Object> map = objmapMap.get(key);
			//遍历这一行的多列的信息
			for(String temp:map.keySet()) {
				System.out.print(map.get(temp)+"\t");
			}
			System.out.println();
		}

	}
		//list(map)
		public static void test02() {
			Connection mysqlConn = JDBCUtil.getMysqlConn();
			PreparedStatement prepareStatement = null;
			ResultSet executeQuery = null;
			List<Map<String, Object>> objmapList =new ArrayList<Map<String,Object>>();
			try {
				prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id >=?");
				prepareStatement.setObject(1, 1);
				executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
					Map<String, Object> objmap= new HashMap<String, Object>();
//					System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
					objmap.put("empname", executeQuery.getString(1));
					objmap.put("salary", executeQuery.getDouble(2));
					objmap.put("age", executeQuery.getInt(3));
					objmapList.add(objmap);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
			}
			for(Map<String, Object> maptemp:objmapList) {
				//遍历这一行的多列的信息
				for(String temp:maptemp.keySet()) {
					System.out.print(maptemp.get(temp)+"\t");
				}
				System.out.println();
			}

		}

		//单行数据
		public static void test03() {
			Connection mysqlConn = JDBCUtil.getMysqlConn();
			PreparedStatement prepareStatement = null;
			ResultSet executeQuery = null;
			Map<String, Object> objmap =new HashMap<String, Object>();
			try {
				prepareStatement = mysqlConn.prepareStatement("select empname,salary,age from emp where id =?");
				prepareStatement.setObject(1, 1);
				executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
//					System.out.println(executeQuery.getString(1)+"--"+executeQuery.getDouble(2)+"--"+executeQuery.getInt(3));
					objmap.put("empname", executeQuery.getString(1));
					objmap.put("salary", executeQuery.getDouble(2));
					objmap.put("age", executeQuery.getInt(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.close(executeQuery, prepareStatement, mysqlConn);
			}
			
			//遍历这一行的多列的信息
			for(String temp:objmap.keySet()) {
				System.out.print(objmap.get(temp)+"\t");
			}
			

		}

	public static void main(String[] args) {
		test03();
		
	}
		

}
