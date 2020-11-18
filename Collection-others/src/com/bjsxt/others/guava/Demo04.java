package com.bjsxt.others.guava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class Demo04 {

	public static void main(String[] args) {
		Set<Integer> set1=Sets.newHashSet(1,2,3,4,5,6);
		Set<Integer> set2=Sets.newHashSet(3,4,5,6,7,8,9);
		System.out.println("jiaoji");
		SetView<Integer> intersection=Sets.intersection(set1, set2);
		for(Integer temp:intersection) {
			System.out.println(temp);
		}
		System.out.println("chaiji");
		SetView<Integer> diff=Sets.difference(set1, set2);
		for(Integer temp:diff) {
			System.out.println(temp);
		}
		System.out.println("bingji");
		SetView<Integer> union=Sets.union(set1, set2);
		for(Integer temp:union) {
			System.out.println(temp);
		}
	}

}
