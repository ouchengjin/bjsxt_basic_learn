package com.bjsxt.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
	private Star realStar;
	
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object invoke=null;
		System.out.println("面谈,签合同，买票");
		if(method.getName().equals("sing")) {
			invoke = method.invoke(realStar, args);
			
		}
		
		System.out.println("收钱");
		
		return invoke;
	}

}
