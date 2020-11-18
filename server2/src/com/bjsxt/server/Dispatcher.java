package com.bjsxt.server;

import java.io.IOException;
import java.net.Socket;

import com.bjsxt.servlet.Servlet;
import com.bjsxt.util.CloseUtil;

/**
 * 一个请求与相应 就一个Dispatcher 	
 * @ClassName: Dispatcher
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-04 22:44:51
 */
public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response rep;
	private int code=200;
	

	public Dispatcher(Socket client) {
		this.client = client;
		try {
			this.req = new Request(client.getInputStream());
			this.rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			code =500;
			return;
		}
	}


	@Override
	public void run() {
		System.out.println("请求报文：\r\n"+req.getRequestInfo());
		try {
			Servlet serv= WebApp.getServlet(req.getUrl());
			if(null==serv) {
				code=404;//找不到对应的处理
			}else {
				serv.service(req, rep);
			}
			rep.pushClient(code);//推送到客户端 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.code=500;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rep.pushClient(500);//浏览器接收一次回应之后就不在接收第二次回应了
		} catch (IOException e) {
			e.printStackTrace();
		}
//		rep.close();
//		req.close();
		CloseUtil.closeSocket(client);
	}

}
