package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器 并启动
 * 1.请求
 * 2.响应
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-27 21:34:17
 */
public class Server4 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server4 server = new Server4();
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
			byte[] data= new byte[20480];
			int len = client.getInputStream().read(data);
			//接收客户端的请求信息
			String requestinfo=new String(data,0,len).trim();
			System.out.println("请求报文：\r\n"+requestinfo);
			
			//响应
			
			Response rep= new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应示例</title>");
			rep.println("</head><body>Hello oss!</body></html>");
			rep.pushClient(404);
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
