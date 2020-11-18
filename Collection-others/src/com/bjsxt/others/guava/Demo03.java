package com.bjsxt.others.guava;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> sets= Sets.newHashSet();
		Constraint<String> constraint= new Constraint<String>() {

			@Override
			public String checkElement(String element) {

				Preconditions.checkNotNull(element);
				Preconditions.checkArgument(element.length()>=5&&element.length()<=20);
				return element;
			}
		};
		
		Set<String> cs = Constraints.constrainedSet(sets, constraint);
		cs.add("goodkk");
		
		for(String temp:cs) {
			System.out.println(temp);
		}
		
	}

}
