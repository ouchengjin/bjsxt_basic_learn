package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器 并启动
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-27 21:34:17
 */
public class Server {
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server server = new Server();
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
			String msg = null;
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if(null==msg) {
					break;
				}
			}
			//接收客户端的请求信息
			String requestinfo=sb.toString().trim();
			System.out.println(requestinfo);
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
