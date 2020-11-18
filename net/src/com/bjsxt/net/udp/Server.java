package com.bjsxt.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1.创建服务端+端口
 * 2.准备接受容器
 * 3.封装成包DatagramPacket(byte[] buf, int length) 
 * 4.接受数据
 * 5.分析数据   字节数组---》转成double类型
 * 6.释放资源
 * @ClassName: MyServer
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-18 12:03:21
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//1.创建服务端+端口
		DatagramSocket server = new DatagramSocket(8888);

		//2.准备接受容器
		byte[] container= new byte[1024];
		//3.封装成包DatagramPacket(byte[] buf, int length) 
		DatagramPacket packet= new DatagramPacket(container, container.length);
		//4.接受数据
		server.receive(packet);
		//5.分析数据
		byte[] data = packet.getData();
//		int len= packet.getLength();
//		System.out.println(new String(data,0,len));
		double num = convert(data);
		System.out.println(num);
		
		//6.释放资源
		server.close();
	}
	
	public static double convert(byte[] data) throws IOException {
		double num = 0;
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		num = dis.readDouble();
		dis.close();
		
		return num ;
	}

}
