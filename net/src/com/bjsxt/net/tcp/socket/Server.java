package com.bjsxt.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动服务器再连接
 * 1.创建服务器，同时指定端口ServerSocket(int port) 创建绑定到特定端口的服务器套接字。
 * 2.接收客户端连接 阻塞式
 * 3.发送数据+接收数据
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-19 19:09:45
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//1.创建服务器，同时指定端口ServerSocket(int port) 创建绑定到特定端口的服务器套接字。
		ServerSocket server = new ServerSocket(8888);//因为和Myserver使用不同协议，故而可以使用同一端口
		//2.接收客户端连接 阻塞式
		Socket socket =server.accept();
		System.out.println("一个客户端建立连接");
		//发送数据
		String msg = "欢迎使用\r\n";
		/*
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();
*/
		DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);	
		dos.flush();
	}

}
