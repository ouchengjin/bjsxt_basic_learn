package com.bjsxt.server.demo1;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器 并启动
 * 1.请求
 * 2.响应
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-27 21:34:17
 */
public class Server5 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server5 server = new Server5();
		server.start();
		
		
	}
	/**
	 * 启动方法
	 * @Title: start
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-04-27 22:28:43
	 */
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * 接收客户端
	 */
	private void receive() {
		try {
			Socket client=server.accept();
			InputStream is =client.getInputStream();
			Request req = new Request(is);
			System.out.println("请求报文：\r\n"+req.getRequestInfo());
			
			//响应
			
			Response rep= new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应示例</title>");
			rep.println("</head><body>");
			rep.println("Hello ").println(req.getParameter("uname")).println(",欢迎回来");
			rep.println("</body></html>");
			rep.pushClient(200);
			System.out.println("返回报文：");
			System.out.println(rep);
			System.out.println(rep.content.toString().getBytes().length);
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 停止
	 */
	public void stop() {
		
	}
}
