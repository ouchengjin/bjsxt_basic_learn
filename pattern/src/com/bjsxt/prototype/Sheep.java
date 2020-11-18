package com.bjsxt.prototype;

import java.io.Serializable;
import java.util.Date;

/**  
 * @ClassName: Sheep
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-31 21:52:30 
*/
public class Sheep implements Cloneable ,Serializable{
	private String name;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj= super.clone();//直接调用Object的clone()方法
		return obj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Sheep() {
		// TODO Auto-generated constructor stub
	}
	public Sheep(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	
}
