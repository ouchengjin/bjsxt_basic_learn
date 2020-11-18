package com.bjsxt.xiangyuanmoshi;

import java.util.HashMap;
import java.util.Map;
//享元工厂类
public class factory {
	//享元池
	private static  Map<String, Weiqiinterface> Weiqiinterfaces=new HashMap<String, Weiqiinterface>();
	
	public static Weiqiinterface getWeiqiinterface(String color) {
		Weiqiinterface ret=Weiqiinterfaces.get(color);
		if (ret==null) {
			ret = new WeiqiShare(color);
			Weiqiinterfaces.put(color, ret);
		}
		
		return ret;
	}
	
}
