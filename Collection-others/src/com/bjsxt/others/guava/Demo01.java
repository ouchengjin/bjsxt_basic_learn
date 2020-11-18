package com.bjsxt.others.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Demo01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> readlist=Collections.unmodifiableList(list);
//		readlist.add("d");//java.lang.UnsupportedOperationException
		list.add("d");
		List<String> immutablelist=ImmutableList.of("a", "b", "c");
		immutablelist.add("d");
	}

}
