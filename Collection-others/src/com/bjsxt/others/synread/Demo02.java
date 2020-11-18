package com.bjsxt.others.synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo02 {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("test", "test");
		map.put("bjsxt","bjsxt");
		
		Map<String, String> map2 = Collections.unmodifiableMap(map);
//		map.put("sa","sa");
		System.out.println(map2.size());
		
		List<String> list = Collections.singletonList(new String());
		System.out.println(list.size());
//		list.add("test");
		
	}
	
	public static Set<String> oper(Set<String> set){
		if(null==set) {
			return Collections.EMPTY_SET;
		}
		return set;
	}

}
