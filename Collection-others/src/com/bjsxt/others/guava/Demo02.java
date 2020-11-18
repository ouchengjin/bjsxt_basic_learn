package com.bjsxt.others.guava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;


import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Demo02 {

	public static void main(String[] args) {
		
		List<String> list= Lists.newArrayList("bjsxt","good","happiness");
		Function<String, String> f1= new Function<String, String>() {

			@Override
			public String apply(String arg0) {
				// TODO Auto-generated method stub
				return arg0.length()>5?arg0.substring(0, 5):arg0;
			}
		};
		Function<String, String> f2= new Function<String, String>() {
			
			@Override
			public String apply(String arg0) {
				// TODO Auto-generated method stub
				return arg0.toUpperCase();
			}
		};
		
		Function<String, String> f= Functions.compose(f1, f2);
		Collection<String> resultCol=  Collections2.transform(list, f);
		for(String temp:resultCol) {
			System.out.println(temp);
		}

	}
	
	public static void test2() {
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(10000000L);
		timeSet.add(9999999999999999L);
		timeSet.add(200000000L);
		Collection<String> timeStrCol=Collections2.transform(timeSet, new Function<Long, String>() {
			
			@Override
			public String apply(Long arg0) {
				return new SimpleDateFormat("yyyy-MM-dd").format(arg0);
			}
		});
		
		for(String temp:timeStrCol) {
			System.out.println(temp);
		}
		
	}
	
	public static void test1() {
		
		List<String> list = Lists.newArrayList("moom","son","dad","bjsxt","refer");
		Collection<String> palindromeList=Collections2.filter(list, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return new StringBuilder(input).reverse().toString().equals(input);
			}
		});
		
		for(String temp:palindromeList) {
			System.out.println(temp);
		}
	}

}
