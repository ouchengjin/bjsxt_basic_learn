package com.bjsxt.regex.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 网络爬虫取链接,我们一般用第三方爬虫插件比如wget
 * @ClassName: WebSpider
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-11 22:15:08
 */
public class WebSpider {

	/**
	 * 获得urlStr对应网页的源码内容
	 * @Title: getUrlContent
	 * @Description: TODO(描述)
	 * @param urlStr
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-11 22:22:28
	 */
	public static  String getUrlContent(String urlStr,String charset) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			URL url = new URL(urlStr);
			InputStream openStream = url.openStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openStream,Charset.forName(charset)));
			String msg="";
			while((msg=bufferedReader.readLine())!=null) {
				stringBuffer.append(msg+"\r\n");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	public static List<String> getMatherSubstrs(String destStr,String regexStr){
		List<String> list = new  ArrayList<String>();
		
//		Pattern compile = Pattern.compile("<a[\\s\\S]+?</a>");//取到超链接的整个内容
		Pattern compile = Pattern.compile(regexStr);//取到超链接的地址
		Matcher matcher = compile.matcher(destStr);
		while(matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}
	public static void main(String[] args) {
		String urlContent = getUrlContent("https://www.163.com","gbk");
//		System.out.println(urlContent);
		List<String> matherSubstrs = getMatherSubstrs(urlContent, "href=\"([\\w\\s./:]+?)\"");
//		
		for (String string : matherSubstrs) {
			System.out.println(string);
			
		}
		
		
		
	}

}
