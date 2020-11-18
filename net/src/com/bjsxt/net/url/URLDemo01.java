package com.bjsxt.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @author author
	 * @throws MalformedURLException 
	 * @date 2020-04-17 21:33:45
	 */
	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");//#aa为锚点，对本网页或本网站资源的跳转.?uname=bjsxt为参数.?是和用户交互的
		System.out.println("协议："+url.getProtocol());
		System.out.println("域名："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("资源："+url.getFile());
		System.out.println("相对路径："+url.getPath());
		System.out.println("锚点："+url.getRef());//锚点
		System.out.println("参数："+url.getQuery());//?参数：存在锚点，作为锚点一部分，返回null，不存在，返回正确
		//相对路径构建
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");
		System.out.println(url.toString());//http://www.baidu.com:80/a/b.txt

		

	}

}
