package com.bjsxt.server.reflect;

public class Demo01 {
public static void main(String[] args) throws ClassNotFoundException {
	String str = "abc";
	//class对象
	//对象.getClass()
	Class<?> clz= str.getClass();
	//类.class
	clz=String.class;
	//完整路径
	clz=Class.forName("java.lang.String");
}
}
