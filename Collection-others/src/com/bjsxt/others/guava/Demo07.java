package com.bjsxt.others.guava;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Demo07 {

	public static void main(String[] args) {

		BiMap<String, String> bimap= HashBiMap.create();
		bimap.put("bjsxt", "bjsxt@sina.com");
		bimap.put("good", "good@qq.com");
		String user=bimap.inverse().get("good@qq.com");
		System.out.println(user);
		System.out.println(bimap.inverse().inverse()==bimap);
	}

}
