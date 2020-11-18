package com.bjsxt.test.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@SuppressWarnings("all")
public class Demo01 /*extends Object*/{ 

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Deprecated
	public static void test001() {
		System.out.println("test001");
	}
	
	public static void test002() {
		List list1= new ArrayList();
		List list2= new ArrayList();
		List list3= new ArrayList();

	}
	public static void main(String[] args) {
		Date d= new Date();
//		d.parse("f");
		test001();
		
	}
}
