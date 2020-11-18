package com.bjsxt.server.demo1;

public class Servlet {
	public void service(Request req,Response rep) {
		rep.println("<html><head><title>HTTP响应示例</title>");
		rep.println("</head><body>");
		rep.println("Hello ").println(req.getParameter("uname")).println(",欢迎回来");
		rep.println("</body></html>");
		
		System.out.println("返回报文：");
		System.out.println(rep);
		System.out.println(rep.content.toString().getBytes().length);
	}
}
