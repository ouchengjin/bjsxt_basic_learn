package com.bjsxt.server.demo4;
/**
 <servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-patern>/login</url-patern>
	</servlet-mapping>
	
	<servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-patern>/log</url-patern>
	</servlet-mapping>>
 */

import java.util.ArrayList;
import java.util.List;

public class Mapping {

	private String name;
	private List<String> urlPatern;
	
	
	public Mapping() {
		urlPatern = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPatern() {
		return urlPatern;
	}
	public void setUrlPatern(List<String> urlPatern) {
		this.urlPatern = urlPatern;
	}
	
	
}
