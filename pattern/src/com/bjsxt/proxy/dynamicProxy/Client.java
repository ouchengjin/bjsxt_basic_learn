package com.bjsxt.proxy.dynamicProxy;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		Star realStar= new RealStar();
		StarHandler starHandler = new StarHandler(realStar);
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, starHandler);
		proxy.sing();
	}

}
