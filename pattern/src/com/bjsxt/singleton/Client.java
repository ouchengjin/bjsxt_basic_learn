package com.bjsxt.singleton;

public class Client {

	public static void main(String[] args) {
		SingletonDemo1 singletonsemo1 = SingletonDemo1.getSingletonsemo1();
		SingletonDemo1 singletonsemo2 = SingletonDemo1.getSingletonsemo1();
		
		System.out.println(singletonsemo1);
		System.out.println(singletonsemo2);
		System.out.println(SingletonDemo5.instance==SingletonDemo5.instance);
	}

}
