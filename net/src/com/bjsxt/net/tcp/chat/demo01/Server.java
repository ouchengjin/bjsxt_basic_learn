package com.bjsxt.net.tcp.chat.demo01;

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
		System.out.println("服务端开始等待连接"+new Date().getTime());
		Socket client=server.accept();
		System.out.println("服务端连接客户端成功"+new Date().getTime());
		//输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println("服务端开始读取数据"+new Date().getTime());
		String msg=dis.readUTF();
		System.out.println("服务端完成读取数据"+new Date().getTime());

		//输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		System.out.println("服务端写socket前"+new Date().getTime());
		dos.writeUTF("服务器---》"+msg);
		dos.flush();
		System.out.println("服务端写socket后"+new Date().getTime());

	}

}



