package com.bjsxt.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建客户端+发送数据+接收数据
 * 写出数据：输出流
 * 读入数据：输入流
 * 输入流和输出流在同一个线程内，应该独立处理彼此独立
 * @ClassName: Client
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-20 21:25:53
 */
public class Client {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 9999);
		System.out.println("客户端建立连接成功"+new Date().getTime());
		//控制台输入流
		new Thread(new Send(client)).start();//一条路径
		new Thread(new Receive(client)).start();//一条路径
		
	}

}
/*
客户端建立连接成功1587561780328
手写前1587561780329
哈哈哈
手写后1587561784847
客户端写socket前1587561784847
客户端写socket后1587561784847
服务器---》哈哈哈
手写前1587561784848


服务端开始等待连接1587561774840
服务端连接客户端成功1587561780327
服务端开始读取数据1587561780328
服务端完成读取数据1587561784847
服务端写socket前1587561784847
服务端写socket后1587561784848

*/