package com.bjsxt.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.bjsxt.servlet.Servlet;

public class WebApp {
	private static ServletContext contxt;
	static {
		
				try {
					//1.获取解析工厂
					SAXParserFactory factory = SAXParserFactory.newInstance();
					//获取解析器
					SAXParser sax= factory.newSAXParser();
					//指定xml+处理器
					WebHandler web= new WebHandler();
					sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("WEB_INFO\\web.xml"), web);
					//将list转成map
					contxt= new ServletContext();
					Map<String, String> servlet=contxt.getServlet();
					//<servlet-name>和<servlet-class>
					List<Entity> entityList= web.getEntityList();
					for(Entity temp:entityList) {
						servlet.put(temp.getName(), temp.getClz());
					}
					
					Map<String, String> mappping=contxt.getMappping();
					// <url-patern>  <servlet-name>
					List<Mapping> mappingList=web.getMappingList();
					for(Mapping maptemp:mappingList) {
						List<String> urlPaternList = maptemp.getUrlPatern();
						for(String temp:urlPaternList) {
							mappping.put(temp,maptemp.getName());
							
						}
					}
					
					
					
						
					
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if((null==url)||(url.trim().equals(""))) {
			return null;
		}
		//根据字符串（完整路径）创建对象
//		return contxt.getServlet().get(contxt.getMappping().get(url));
		String name=contxt.getServlet().get(contxt.getMappping().get(url));
		return (Servlet)Class.forName(name).newInstance(); //确保空构造存在才可以做这一步 
	}

}
