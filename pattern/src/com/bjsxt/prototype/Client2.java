package com.bjsxt.prototype;

import java.util.Date;

/**
 * 测试原型模式（深克隆）
 * @ClassName: Client2
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-31 22:15:49
 */
public class Client2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(111111L);
		Sheep2 s1= new Sheep2("少利",date);
		Sheep2 s2= (Sheep2) s1.clone();//实现深复制，s2的birthday是一个新对象 
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
		
		date.setTime(345353555L);
		s2.setName("多利");
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	
	}

}
