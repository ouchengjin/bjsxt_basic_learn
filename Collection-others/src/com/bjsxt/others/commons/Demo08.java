package com.bjsxt.others.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag ���������ظ�
 * 1.HashBag����
 * 2.TreeBag����
 * @ClassName: Demo08
 * @Description: TODO(����)
 * @author author
 * @date 2020-03-10 22:13:51
 */
public class Demo08 {

	public static void main(String[] args) {
//		hashBag();
//		treeBag();
		String str = "this is a cat and that is a mice where is the food";
		//�ָ��ַ���
		String[] strarray=str.split(" ");
		Bag<String> bag= new TreeBag<String>();
		for(String temp:strarray) {
			bag.add(temp);
		}
		
		System.out.println("ͳ�ƴ���");
		Set<String> keys= bag.uniqueSet();
		for(String letter:keys) {
			System.out.println(letter+"----����-------��"+bag.getCount(letter));
		}
	}
	
	/**
	 * ����İ�
	 */
	public static void treeBag() {
		System.out.println("=========����İ�========");
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
	 * ����İ�
	 */
	public static void hashBag() {
		System.out.println("=========����İ�========");
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