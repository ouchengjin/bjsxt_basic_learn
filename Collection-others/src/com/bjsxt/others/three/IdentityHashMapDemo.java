package com.bjsxt.others.three;

import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
	
	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map.size());
		map.put(new String("a"), "a1");
		map.put(new String("a"), "a2");
		System.out.println(map.size());
	}

}
