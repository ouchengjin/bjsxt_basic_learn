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
 * ����������չ
 * @ClassName: Demo06
 * @Description: TODO(����)
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
	 * ���������
	 * @Title: arrayIt
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-10 21:43:23
	 */
	public static void arrayIt() {
		System.out.println("========���������===========");
		int[] array = {1,2,3,4,5};
//		Iterator<Integer> it = new ArrayIterator<Integer>(array);
		//�ƶ���ʼ�����ͽ�������
		Iterator<Integer> it = new ArrayIterator<Integer>(array, 1, 3);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * ѭ��������
	 * @Title: loopIt
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-10 21:33:04
	 */
	public static void loopIt() {
		System.out.println("============ѭ��������=============");
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
	 * �Զ��������
	 */
	public static void filterIt() {
		System.out.println("=========�Զ��������=============");
		List<String> list = new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		//�Զ�������
		Predicate<String> pre = new Predicate<String>() {

			@Override
			public boolean evaluate(String value) {
				// �����ж�
				return new StringBuilder(value).reverse().toString().equals(value);
			}

		};
		//ȥ���ظ��Ĺ�����
		Iterator<String> it = new FilterIterator(list.iterator(), pre);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * ȥ�ص�����
	 */
	public static void uniqueIt() {
		System.out.println("=========ȥ�ص�����=============");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//ȥ���ظ��Ĺ�����
		Iterator<String> it = new UniqueFilterIterator<String>(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * map������
	 * @Title: mapIt
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-08 21:49:51
	 */
	public static void mapIt() {
		System.out.println("=========map������=============");
		IterableMap<String, String> map = new HashedMap<String, String>();
//		MapIterator dd = (MapIterator) map.keySet().iterator();
		map.put("a", "bjsxt");
		map.put("b", "is");
		map.put("c", "good");
		//ʹ��MapIterator
		MapIterator<String, String> it = map.mapIterator();
		while(it.hasNext()) {
			//һ��Ҫit.next()
			String key = it.next();
			String value = it.getValue();
			
			System.out.println(key+"----->"+value);
		}
	}

}
