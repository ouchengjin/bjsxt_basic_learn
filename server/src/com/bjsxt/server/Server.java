package com.bjsxt.server;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.bjsxt.util.CloseUtil;

/**
 * 创建服务器 并启动
 * 1.请求
 * 2.响应
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-27 21:34:17
 */
public class Server {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	private boolean isShutDown=false;
	
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
		start(8888);
	}
	/**
	 * 指定端口的启动方法
	 * @Title: start
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-04-27 22:28:43
	 */
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			stop();
		}
		
	}

	/*
	 * 接收客户端
	 */
	private void receive() {
		try {
			while(!isShutDown) {
				new Thread(new Dispatcher(server.accept())).start();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			stop();
			
		}
	}
	/*
	 * 停止
	 */
	public void stop() {
		isShutDown=true;
		CloseUtil.closeSocket(server);
	}
}
