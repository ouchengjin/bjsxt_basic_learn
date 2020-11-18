package com.bjsxt.others.commons;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 迭代器的拓展
 * @ClassName: Demo06
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-08 21:29:52
 */
public class Demo06 {
	
	public static void main(String[] args) {
//		mapIt();
//		uniqueIt();
//		filterIt();
//		loopIt();
		arrayIt();
	}
	
	/**
	 * 数组迭代器
	 * @Title: arrayIt
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-10 21:43:23
	 */
	public static void arrayIt() {
		System.out.println("========数组迭代器===========");
		int[] array = {1,2,3,4,5};
//		Iterator<Integer> it = new ArrayIterator<Integer>(array);
		//制定起始索引和结束索引
		Iterator<Integer> it = new ArrayIterator<Integer>(array, 1, 3);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 循环迭代器
	 * @Title: loopIt
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-10 21:33:04
	 */
	public static void loopIt() {
		System.out.println("============循环迭代器=============");
		List<String> list = new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		
		Iterator<String> it=new LoopingIterator<String>(list);
		for (int i=0;i<50000000;i++) {
			System.out.println(it.next());
			
		}
	}
	
	/**
	 * 自定义迭代器
	 */
	public static void filterIt() {
		System.out.println("=========自定义迭代器=============");
		List<String> list = new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		//自定义条件
		Predicate<String> pre = new Predicate<String>() {

			@Override
			public boolean evaluate(String value) {
				// 回文判断
				return new StringBuilder(value).reverse().toString().equals(value);
			}

		};
		//去除重复的过滤器
		Iterator<String> it = new FilterIterator(list.iterator(), pre);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 去重迭代器
	 */
	public static void uniqueIt() {
		System.out.println("=========去重迭代器=============");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//去除重复的过滤器
		Iterator<String> it = new UniqueFilterIterator<String>(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * map迭代器
	 * @Title: mapIt
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-08 21:49:51
	 */
	public static void mapIt() {
		System.out.println("=========map迭代器=============");
		IterableMap<String, String> map = new HashedMap<String, String>();
//		MapIterator dd = (MapIterator) map.keySet().iterator();
		map.put("a", "bjsxt");
		map.put("b", "is");
		map.put("c", "good");
		//使用MapIterator
		MapIterator<String, String> it = map.mapIterator();
		while(it.hasNext()) {
			//一定要it.next()
			String key = it.next();
			String value = it.getValue();
			
			System.out.println(key+"----->"+value);
		}
	}

}
