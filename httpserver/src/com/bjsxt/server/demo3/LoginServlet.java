package com.bjsxt.server.demo3;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req,Response rep) throws Exception {
		if(login(req)) {
			rep.println("登陆成功");
		}else {
			rep.println("登陆失败");
		}
		
		System.out.println("返回报文：");
		System.out.println(rep);
		System.out.println(rep.content.toString().getBytes().length);
	}
	
	public boolean login(Request req) {
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		return name.equals("bjsxt")&&pwd.equals("123456");
		
	}

	@Override
	public void doPost(Request req,Response rep) throws Exception {
		
	}

}
