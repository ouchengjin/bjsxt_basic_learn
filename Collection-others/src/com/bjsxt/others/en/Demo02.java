package com.bjsxt.others.en;

import java.util.StringTokenizer;

public class Demo02 {

	public static void main(String[] args) {
		String emailStr ="bjsxt@163.com;bjsxt@qq.com;bjsxt@sohu.com";
		StringTokenizer token = new StringTokenizer(emailStr, ";");
		while(token.hasMoreElements()) {
			System.out.println(token.nextElement());
		}
	}
}
