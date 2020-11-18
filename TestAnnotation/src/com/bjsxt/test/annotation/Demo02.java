package com.bjsxt.test.annotation;

@SxtAnnotation01
public class Demo02 {
	
	@SxtAnnotation01(age=11,id=112,studentName="ouchengjin",schools= {"北京大学","中国传媒大学"})
	public void test1() {
		
	}
	
	@SxtAnnotation02(value="aaaa")
	public void test02() {
		
	}

	public static void main(String[] args) {
		

	}

}
