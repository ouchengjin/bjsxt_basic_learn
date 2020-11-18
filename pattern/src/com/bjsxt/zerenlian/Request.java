package com.bjsxt.zerenlian;
/**
 * 封装请假的基本信息
 * @ClassName: Request
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-06 16:59:53
 */
public class Request {

	private String name;
	private int qingjiaTime;
	private String reason;
	public Request() {
		// TODO Auto-generated constructor stub
	}
	public Request(String name, int qingjiaTime, String reason) {
		super();
		this.name = name;
		this.qingjiaTime = qingjiaTime;
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQingjiaTime() {
		return qingjiaTime;
	}
	public void setQingjiaTime(int qingjiaTime) {
		this.qingjiaTime = qingjiaTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
