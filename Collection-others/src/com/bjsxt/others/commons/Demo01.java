package com.bjsxt.others.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

public class Demo01 {

	public static void main(String[] args) {

		System.out.println("=======自定义判断===========");
		Predicate<String> selfPre= new Predicate<String>() {
			@Override
			public boolean evaluate(String object) {
				// TODO Auto-generated method stub
				return object.length()>=5&&object.length()<=20;
			}
		};
		Predicate notnull=NotNullPredicate.notNullPredicate();
		
		Predicate all =PredicateUtils.allPredicate(notnull,selfPre);
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		list.add("bjsxt");
//		list.add(null);
		list.add("bj");
	}
	
	public static void unique() {
		System.out.println("===========唯一性判断============");
		Predicate<Long> unique= UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), unique);
		list.add(100L);
		list.add(200L);
		list.add(100L);
		
	}
	
	public static void notNull() { 
		System.out.println("============非空判断=============");
//		Predicate notnull=NotNullPredicate.INSTANCE;
		Predicate notnull=NotNullPredicate.notNullPredicate();
//		String str = "bjsxt";
		String str = null;
		System.out.println(notnull.evaluate(str));
		
		List<Long> list=PredicatedList.predicatedList(new ArrayList<Long>(), notnull);
		list.add(1000L);
		list.add(null);
		
		
	}
	
	public  static void equal() {
		
		System.out.println("相等判断");
//		Predicate<String> pre = new EqualPredicate<String>("bjsxt");
		Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");
		Boolean flag=pre.evaluate("bj");
		System.out.println(flag);
	}

}
