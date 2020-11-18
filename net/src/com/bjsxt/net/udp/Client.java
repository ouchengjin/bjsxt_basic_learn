package com.bjsxt.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据 double--》转成字节数组   字节数组输出流，以程序为中心理解
 * 3.打包（发送的地点及端口）
 * 4.发送
 * 5.释放
 * 
 * 
 * @ClassName: MyClient
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-18 12:03:35
 */
public class Client {

	public static void main(String[] args) throws IOException {
		//1.创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);//和服务端同一台计算机，不可相同端口
		//2.准备数据
//		String msg= "UDP编程";
//		byte[] data= msg.getBytes();
		double num =89.12;
		byte[] data=convert(num);
		//3.打包（发送的地点及端口）DatagramPacket(byte[] buf, int length, SocketAddress address) 
		DatagramPacket packet= new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//4.发送
		client.send(packet);
		//5.释放
		client.close();

	}
	/**
	 * 字节数组 数据源+data 输出流
	 * @Title: convert
	 * @Description: TODO(描述)
	 * @param num
	 * @return
	 * @author author
	 * @throws IOException 
	 * @date 2020-04-18 23:03:31
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data=null;
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data = bos.toByteArray();
		dos.close();
		bos.close();
		
		
		
		return data;
	}

}
