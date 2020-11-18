package com.bjsxt.server.demo3;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static {
		contxt= new ServletContext();
		Map<String, String> mappping=contxt.getMappping();
		mappping.put("/login", "login");
		mappping.put("/log", "login");
		mappping.put("/reg", "register");
		
		
		Map<String, String> servlet=contxt.getServlet();	
		servlet.put("login", "com.bjsxt.server.demo3.LoginServlet");
		servlet.put("register", "com.bjsxt.server.demo3.RegisterServlet");
		
		
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if((null==url)||(url.trim().equals(""))) {
			return null;
		}
		//根据字符串（完整路径）创建对象
//		return contxt.getServlet().get(contxt.getMappping().get(url));
		String name=contxt.getServlet().get(contxt.getMappping().get(url));
		return (Servlet)Class.forName(name).newInstance(); //确保空构造存在才可以做这一步 
	}

}
