package com.bjsxt.server.demo2;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static {
		contxt= new ServletContext();
		Map<String, String> mappping=contxt.getMappping();
		mappping.put("/login", "login");
		mappping.put("/log", "login");
		mappping.put("/reg", "register");
		
		
		Map<String, Servlet> servlet=contxt.getServlet();	
		servlet.put("login", new LoginServlet());
		servlet.put("register", new RegisterServlet());
		
		
	}
	
	public static Servlet getServlet(String url) {
		if((null==url)||(url.trim().equals(""))) {
			return null;
		}
		return contxt.getServlet().get(contxt.getMappping().get(url));
	}

}
