package com.bjsxt.prototype;

import java.util.Date;

/**
 * 测试原型模式（浅克隆）
 * @ClassName: Client
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-31 21:53:27
 */
public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(111111L);
		Sheep s1= new Sheep("少利",date );
		Sheep s2= (Sheep) s1.clone();
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
