package com.bjsxt.server.demo3;
/**
 * 上下文
 * @ClassName: ServletContext
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-05 19:31:39
 */

import java.util.HashMap;
import java.util.Map;
/**
 * 因为一个Servlet对应多个mappping，所以起别名的作用是减少了存储Servlet对象的个数，节省内存
 * @ClassName: ServletContext
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-05 20:31:58
 */
public class ServletContext {
	//为每一个servlet起一个别名
	//login-->com.bjsxt.server.demo03.LoginServlet
	private Map<String, String> servlet;
	//url-->login
	//  /log-->login
	//  /login-->login
	private Map<String, String> mappping;
	
	ServletContext() {
		servlet= new HashMap<String, String>();
		mappping=new HashMap<String, String>();
	}
	
	
	
	
	
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMappping() {
		return mappping;
	}
	public void setMappping(Map<String, String> mappping) {
		this.mappping = mappping;
	}

}
