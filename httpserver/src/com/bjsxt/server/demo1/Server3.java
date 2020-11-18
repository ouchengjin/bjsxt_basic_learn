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
public class Server3 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server3 server = new Server3();
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
			System.out.println(requestinfo);
			
			//响应
			StringBuilder responseContext=new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应示例</title>"
					+ "</head><body>Hello bjsxt!</body></html>");
			
			StringBuilder response= new StringBuilder();
			//1)HTTP协议版本，状态代码，描述
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2)  响应头(Response Head)
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=utf-8").append(CRLF);
			//正文长度 ：字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//3)正文之前
			response.append(CRLF);
			//4)正文
			response.append(responseContext);
			System.out.println(responseContext);
			System.out.println();
			System.out.println(response);
			
			
			//输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
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
