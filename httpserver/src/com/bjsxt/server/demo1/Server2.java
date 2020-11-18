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
public class Server2 {
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server2 server = new Server2();
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
			byte[] data= new byte[20480];
			int len = client.getInputStream().read(data);
			//接收客户端的请求信息
			String requestinfo=new String(data,0,len).trim();
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
