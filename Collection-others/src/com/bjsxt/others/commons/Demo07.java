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
	 * �����˫��map
	 * @Title: hashMap
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-10 21:55:38
	 */
	public static void treehMap() {
		System.out.println("======�����˫��map======");
		BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		
		//�����鿴
		MapIterator<String, String> it= map.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key= it.next();
			String value= it.getValue();
			System.out.println(key+"------>"+value);
		}
		
	}
	
	/**
	 * �����˫��map
	 * @Title: hashMap
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-10 21:55:38
	 */
	public static void hashMap() {
		System.out.println("======�����˫��map======");
		BidiMap<String, String> map = new DualHashBidiMap<String, String>();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		//��ת
		System.out.println(map.inverseBidiMap().get("sxt@qq.com"));
		//�����鿴
		MapIterator<String, String> it= map.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key= it.next();
			String value= it.getValue();
			System.out.println(key+"------>"+value);
		}
		
	}
}
