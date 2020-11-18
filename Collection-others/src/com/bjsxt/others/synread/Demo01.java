package com.bjsxt.others.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("b");
		List<String> synlist=Collections.synchronizedList(list);
		System.out.println("线程安全的lsit制作完毕");
		

	}

}
