package com.bjsxt.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 没有封装端口
 * @ClassName: InetDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-16 22:10:40
 */
public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//输出本机ip
		System.out.println(addr.getHostName());//输出计算机名
		//根据域名使用getByName方法创建InetAddress对象
		addr=InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//输出本机ip
		System.out.println(addr.getHostName());//输出计算机名
		//根据ip使用getByName方法创建InetAddress对象
		addr=InetAddress.getByName("182.18.72.131");
		System.out.println(addr.getHostAddress());//输出本机ip
		System.out.println(addr.getHostName());//输出计算机名

	}

}
