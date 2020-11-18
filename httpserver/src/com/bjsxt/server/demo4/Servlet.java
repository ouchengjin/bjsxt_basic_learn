package com.bjsxt.server.demo4;
/**
 * 抽象为一个父类
 * @ClassName: Servlet
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-05 20:01:35
 */
public abstract class Servlet {
	  protected void service(Request req,Response rep) throws Exception {
		this.doGet( req,rep);
		this.doPost(req,rep);
		
	}
	
	public abstract void  doGet(Request req,Response rep) throws Exception;
	public abstract void  doPost(Request req,Response rep) throws Exception;
}
