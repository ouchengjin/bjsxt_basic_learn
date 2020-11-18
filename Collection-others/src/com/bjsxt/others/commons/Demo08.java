package com.bjsxt.others.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag 包，允许重复
 * 1.HashBag无序
 * 2.TreeBag有序
 * @ClassName: Demo08
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-10 22:13:51
 */
public class Demo08 {

	public static void main(String[] args) {
//		hashBag();
//		treeBag();
		String str = "this is a cat and that is a mice where is the food";
		//分割字符串
		String[] strarray=str.split(" ");
		Bag<String> bag= new TreeBag<String>();
		for(String temp:strarray) {
			bag.add(temp);
		}
		
		System.out.println("统计次数");
		Set<String> keys= bag.uniqueSet();
		for(String letter:keys) {
			System.out.println(letter+"----次数-------》"+bag.getCount(letter));
		}
	}
	
	/**
	 * 有序的包
	 */
	public static void treeBag() {
		System.out.println("=========有序的包========");
		Bag<String> bag = new TreeBag<String>();
		bag.add("a");
		bag.add("a", 5);
		bag.remove("a", 2);
		bag.add("b");
		bag.add("c");
		Iterator<String> it= bag.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 无序的包
	 */
	public static void hashBag() {
		System.out.println("=========无序的包========");
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a", 5);
		bag.remove("a", 2);
		bag.add("b");
		bag.add("c");
		Iterator<String> it= bag.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
