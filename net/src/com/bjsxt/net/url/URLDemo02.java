package com.bjsxt.net.url;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取资源：源代码
 * @ClassName: URLDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-17 21:54:23
 */
public class URLDemo02 {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.baidu.com");//主页或者默认资源
		
		//获取资源 网络流
		/*
		InputStream is =url.openStream();
		byte[] flush= new byte[1024];
		int len = 0;
		while(-1!=(len= is.read(flush))) {
			System.out.println(new String(flush));
		}
		is.close();
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String msg=null;
		while(null!=(msg= br.readLine())) {
//			System.out.println(br.readLine());
//			bw.write(msg);;
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
