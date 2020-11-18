package com.bjsxt.others.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

public class Demo07 {

	public static void main(String[] args) {
		hashMap();
		treehMap();
	}

	/**
	 * 有序的双向map
	 * @Title: hashMap
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-10 21:55:38
	 */
	public static void treehMap() {
		System.out.println("======有序的双向map======");
		BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		
		//遍历查看
		MapIterator<String, String> it= map.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key= it.next();
			String value= it.getValue();
			System.out.println(key+"------>"+value);
		}
		
	}
	
	/**
	 * 无序的双向map
	 * @Title: hashMap
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-10 21:55:38
	 */
	public static void hashMap() {
		System.out.println("======无序的双向map======");
		BidiMap<String, String> map = new DualHashBidiMap<String, String>();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		//反转
		System.out.println(map.inverseBidiMap().get("sxt@qq.com"));
		//遍历查看
		MapIterator<String, String> it= map.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key= it.next();
			String value= it.getValue();
			System.out.println(key+"------>"+value);
		}
		
	}
}
