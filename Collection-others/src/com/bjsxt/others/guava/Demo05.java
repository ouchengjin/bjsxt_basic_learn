package com.bjsxt.others.guava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Demo05 {

	public static void main(String[] args) {
		String str = "this is a cat and that is a mice where is the food";
		
		String[] strarray=str.split(" ");
		Multiset<String> set = HashMultiset.create();
		for(String temp:strarray) {
			
			set.add(temp);
		}
		
		Set<String> letters= set.elementSet();
		for(String temp:letters) {
			System.out.println(temp+"-------->"+set.count(temp));
		}
	}

}
