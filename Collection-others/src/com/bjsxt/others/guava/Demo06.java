package com.bjsxt.others.guava;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Demo06 {

	public static void main(String[] args) {

		Map<String, String> course= new HashMap<String, String>();
		
		course.put("改革开放", "邓爷爷");
		course.put("三个代表", "江主席");
		course.put("科学发展观", "胡主席");
		course.put("和谐社会", "胡主席");
		course.put("八荣八耻", "胡主席");
		course.put("。。。。。。。", "习主席");
		
		Multimap<String, String> teachers=ArrayListMultimap.create();
		
		Iterator<Map.Entry<String, String>> it = course.entrySet().iterator();
		 while(it.hasNext()) {
			 Map.Entry<String, String> entry = it.next();
			 String key = entry.getKey();
			 String value = entry.getValue();
			 teachers.put(value, key);
		 }
		 
		 Set<String> keyset= teachers.keySet();
		 for(String key:keyset) {
			 Collection<String> col=teachers.get(key);
			 System.out.println(key+"--------->"+col);
		 }
		
	}

}
