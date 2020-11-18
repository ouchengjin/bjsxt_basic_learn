package com.bjsxt.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.print.attribute.standard.SheetCollate;

/**
 * 原型模式（深克隆，使用序列化和反序列化的方式实现深复制）
 * @ClassName: Client3
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-01 21:45:59
 */
public class Client3 {

	public static void main(String[] args) throws Exception {
		
		
		Date date = new Date(111111L);
		Sheep s1= new Sheep("少利",date );
//		Sheep s2= (Sheep) s1.clone();
//		使用序列化和反序列化实现深克隆
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] byteArray = bos.toByteArray();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
		ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
		Sheep s2 = (Sheep) ois.readObject();//克隆好的对象
		
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
		
		date.setTime(345353555L);
		System.out.println("修改原型对象属性值");
		s2.setName("多利");
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	
	
	}

}
