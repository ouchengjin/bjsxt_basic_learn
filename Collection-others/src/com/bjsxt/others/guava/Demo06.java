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
		
		course.put("�ĸ￪��", "��үү");
		course.put("��������", "����ϯ");
		course.put("��ѧ��չ��", "����ϯ");
		course.put("��г���", "����ϯ");
		course.put("���ٰ˳�", "����ϯ");
		course.put("��������������", "ϰ��ϯ");
		
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
