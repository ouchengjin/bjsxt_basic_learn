package com.bjsxt.others.three;

import java.util.EnumMap;

public class EnumMapDemo {

	public static void main(String[] args) {

		EnumMap<season, String> map = new EnumMap<season, String>(season.class);
		map.put(season.spring, "����");
		map.put(season.summer, "����");
		map.put(season.autumn, "����");
		map.put(season.winter, "����");
		System.out.println(map.size());
	}

}
 enum season{
	 spring,summer,autumn,winter
 }