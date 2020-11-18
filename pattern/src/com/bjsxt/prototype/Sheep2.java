package com.bjsxt.prototype;

import java.util.Date;

/**  
 * @ClassName: Sheep
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-31 21:52:30 
*/
public class Sheep2 implements Cloneable {
	private String name;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj= super.clone();//直接调用Object的clone()方法
		
		//添加以下代码实现深克隆
		Sheep2 s=(Sheep2)obj;
		s.birthday= (Date) this.birthday.clone();
		return s;
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
	public Sheep2() {
		// TODO Auto-generated constructor stub
	}
	public Sheep2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	
}
