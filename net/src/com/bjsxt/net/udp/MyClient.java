package com.bjsxt.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据
 * 3.打包（发送的地点及端口）
 * 4.发送
 * 5.释放
 * 
 * 思考：89.12，数据+类型
 * @ClassName: MyClient
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-18 12:03:35
 */
public class MyClient {

	public static void main(String[] args) throws IOException {
		//1.创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);//和服务端同一台计算机，不可相同端口
		//2.准备数据
		String msg= "UDP编程";
		byte[] data= msg.getBytes();
		//3.打包（发送的地点及端口）DatagramPacket(byte[] buf, int length, SocketAddress address) 
		DatagramPacket packet= new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//4.发送
		client.send(packet);
		//5.释放
		client.close();

	}

}
