package com.bjsxt.net.tcp.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器
 *  写出数据：输出流
 * 读入数据：输入流
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-20 21:25:27
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
		Socket client=server.accept();
		//输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());

		while(true) {
		String msg=dis.readUTF();

		//输出流
		dos.writeUTF("服务器---》"+msg);
		dos.flush();
		}
		}

	}
private class Haha implements Runnable{
	
	
	public void read(ServerSocket server) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
}
 


