package com.bjsxt.net.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *1. 创建客户端  必须指定服务器+端口  此时就在连接
 * Socket(String host, int port) 创建一个流套接字并将其连接到指定主机上的指定端口号。
 * 2.接收数据+发送数据
 * @ClassName: Client
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-19 19:34:56
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 创建客户端  必须指定服务器+端口  此时就在连接
		Socket client = new Socket("localhost", 8888);//此处写的服务端信息，客户端发送需要的端口由系统自动指定
		/*
		BufferedReader br= new BufferedReader(new InputStreamReader(client.getInputStream()));
		String msg= br.readLine();
		System.out.println(msg);
		*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg= dis.readUTF();
		System.out.println(msg);
	
	}

}
