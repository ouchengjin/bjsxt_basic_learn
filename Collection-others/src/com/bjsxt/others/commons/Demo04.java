package com.bjsxt.others.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * ����
 * ����
 * �
 * @ClassName: Demo04
 * @Description: TODO(����)
 * @author author
 * @date 2020-03-08 15:05:15
 */
public class Demo04 {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(����)
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
		
		//����
		System.out.println("==========����=============");
		Collection<Integer>col=CollectionUtils.union(set1, set2);
		for(Integer temp:col) {
			System.out.println(temp);
		}
		//����
		System.out.println("==========����=============");
//		col=CollectionUtils.intersection(set1, set2);
		col=CollectionUtils.retainAll(set1, set2);
		for(Integer temp:col) {
			System.out.println(temp);
		}
		
		//�
		System.out.println("==========�=============");
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
