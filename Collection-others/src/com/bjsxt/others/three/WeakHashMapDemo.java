package com.bjsxt.others.three;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<String, String>();
		map.put("a", "k");
		map.put("b", "k");
		map.put(new String("c"), "k");
		map.put(new String("d"), "k");
		System.out.println(map.size());
		System.gc();
		System.runFinalization();
		System.out.println(map.size());
	}
}
