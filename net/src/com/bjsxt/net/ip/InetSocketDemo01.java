package com.bjsxt.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口：在InetAddress基础上+端口
 * @ClassName: InetSocketDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-16 22:11:07
 */
public class InetSocketDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetSocketAddress address= new InetSocketAddress("localhost", 9999);
//		InetSocketAddress address= new InetSocketAddress("127.0.0.1", 9999);
//		InetSocketAddress address= new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress addr= address.getAddress();
		System.out.println(addr.getHostAddress());//输出地址
		System.out.println(addr.getHostName());//输出计算机名

	}

}
