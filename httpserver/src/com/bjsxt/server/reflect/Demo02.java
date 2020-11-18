package com.bjsxt.server.reflect;

import com.bjsxt.server.demo3.Servlet;

/**
 * 创建实例，调用空构造
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-06 22:28:46
 */
public class Demo02 {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz= Class.forName("com.bjsxt.server.demo3.LoginServlet");
		Servlet ser=(Servlet)clz.newInstance();//确保空构造存在才可以做这一步
//		return ser;
	}
}
