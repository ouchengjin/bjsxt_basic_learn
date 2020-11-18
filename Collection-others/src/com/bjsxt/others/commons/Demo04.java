package com.bjsxt.others.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 并集
 * 交集
 * 差集
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-08 15:05:15
 */
public class Demo04 {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @author author
	 * @date 2020-03-08 15:06:33
	 */
	public static void main(String[] args) {
		Set<Integer> set1= new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2= new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		//并集
		System.out.println("==========并集=============");
		Collection<Integer>col=CollectionUtils.union(set1, set2);
		for(Integer temp:col) {
			System.out.println(temp);
		}
		//交集
		System.out.println("==========交集=============");
//		col=CollectionUtils.intersection(set1, set2);
		col=CollectionUtils.retainAll(set1, set2);
		for(Integer temp:col) {
			System.out.println(temp);
		}
		
		//差集
		System.out.println("==========差集=============");
		col = CollectionUtils.subtract(set1, set2);
		Iterator<Integer> colIt= col.iterator();
//		while(colIt.hasNext()) {
//			System.out.println(colIt.next());
//		}
		for(Integer temp:col) {
			System.out.println(temp);
		}
	}

}
