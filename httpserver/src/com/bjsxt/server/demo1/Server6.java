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
public class Server6 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server6 server = new Server6();
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
			Request req = new Request(client.getInputStream());
			System.out.println("请求报文：\r\n"+req.getRequestInfo());
			Response rep= new Response(client.getOutputStream());
			new Servlet().service(req, rep);
			rep.pushClient(200);
			
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
