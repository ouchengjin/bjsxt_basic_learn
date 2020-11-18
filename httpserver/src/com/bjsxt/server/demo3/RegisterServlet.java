package com.bjsxt.server.demo3;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req,Response rep) throws Exception {
		
	}

	@Override
	public void doPost(Request req,Response rep) throws Exception {
		rep.println("<html><head><title>返回注册</title>");
		rep.println("</head><body>");
		rep.println("你的用户名为："+req.getParameter("uname"));
		rep.println("</body></html>");
		
		System.out.println("返回报文：");
		System.out.println(rep);
		System.out.println(rep.content.toString().getBytes().length);
	}

}
