package com.bjsxt.server.demo2;
/**
 * 封装request
 * @ClassName: Request
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-03 21:17:35
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.bjsxt.util.CloseUtil;

public class Request {
	//请求方式
	private String method;
	//请求资源
	private String url;
	private Map<String, List<String>> parameterMapValues;
	//内部
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;

	public Request() {
		this.method = "";
		this.url = "";
		this.parameterMapValues = new HashMap<String, List<String>>();
		this.requestInfo = "";
	}
	
	public Request(InputStream is) {
		this();
		byte[] data=new byte[204800];
		int len;
		try {
			len = is.read(data);
			System.out.println(data.length+"   "+len);
			requestInfo= new String(data, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		//分析请求信息
		paraseRequestInfo();
		
		
	}

	/*
	 * 分析请求信息
	 */
	private void paraseRequestInfo() {
		if(null==requestInfo||requestInfo.trim().equals("")){
			return;
			
			
		}
		/*
		 * ===================================================================
		 * 从信息的首行分解出：请求方式，请求资源，请求参数（get可能存在）
		 * 如GET /index.html?name=123&pwd=235 HTTP/1.1
		 * 
		 * 如果为post方式，请求参数可能在最后正文中
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ===================================================================
		 */
		String paramString="";//接收请求参数
		//获取请求参数
		String firstLine= requestInfo.substring(0, requestInfo.indexOf(this.CRLF));
		int index= requestInfo.indexOf("/");
		method=firstLine.substring(0, index).trim();
		String urlStr= firstLine.substring(index, firstLine.indexOf("HTTP/")).trim();
		if(method.equalsIgnoreCase("post")) {
			this.url= urlStr;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF));
		}else if(method.equalsIgnoreCase("get")) {
			if(urlStr.contains("?")) {
				String[] urlArray=urlStr.split("\\?");
				this.url=urlArray[0];
				paramString=urlArray[1];//接收请求参数
			}else {
				this.url= urlStr;
			}
		}
		//不存在请求参数
		if(paramString.equals("")) {
			return;
		}
		//2.将请求参数封装到Map中
		parseParams(paramString);
		System.out.println(parameterMapValues);
	}
	
	/*
	 * 2.将请求参数封装到Map中
	 */
	private void parseParams(String paramString) {
//		String[] paramarray=paramString.split("&");
//		for(int i=0;i<paramarray.length;i++) {
//			String[] temp=paramarray[i].split("=");
//			List<String> listTemp= new ArrayList<String>();
//			listTemp.add(temp[1]);
//			if(parameterMapValues.containsKey(temp[0])) {
//				parameterMapValues.get(temp[0]).add(temp[1]);
//			}else {
//				parameterMapValues.put(temp[0],listTemp );
//				
//			}
//			
//		}
//		System.out.println(parameterMapValues);
		//分割 将字符串转成数组	
		StringTokenizer token=new StringTokenizer(paramString, "&");
		while(token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] keyValues= keyValue.split("=");
			if(keyValues.length==1) {
				keyValues=Arrays.copyOf(keyValues, 2);
				
			}
			String key = keyValues[0].trim();//果然是这里去除了回车换行符
			String value= null==keyValues[1]?null:decode(keyValues[1].trim(),"utf-8");
			//转换成Map 分拣
			if(!parameterMapValues.containsKey(key)) {
				parameterMapValues.put(key, new ArrayList<String>());
			}else {
				
				
			}
			List<String> values= parameterMapValues.get(key);
			values.add(value);
			
		}
		
	}
	/**
	 * 
	 * @Title: decode
	 * @Description: 解决中文的显示问题
	 * @return
	 * @author author
	 * @date 2020-05-04 21:57:15
	 */
	private String decode(String value,String code) {
		try {
			return java.net.URLDecoder.decode(value,code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @Title: getName
	 * @Description:根据页面name获取对应的值
	 * @return
	 * @author author
	 * @date 2020-05-04 21:20:25
	 */
	public String[] getParameterValues(String name) {
		List<String> values;
		if((values=parameterMapValues.get(name))==null) {
			return null;
		}
		return values.toArray(new String[0]);
	}
	/**
	 * 
	 * @Title: getParameter
	 * @Description:根据页面name获取对应的单个值
	 * @return
	 * @author author
	 * @date 2020-05-04 21:20:25
	 */
	public String getParameter(String name) {
		String[] values=getParameterValues(name);
		if(values==null) {
			return null;
		}
		return values[0];
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
	
	public void close() {
		CloseUtil.closeIO(is);
	}
	
	}
