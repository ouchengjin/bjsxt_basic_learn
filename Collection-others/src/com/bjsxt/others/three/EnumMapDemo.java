package com.bjsxt.others.three;

import java.util.EnumMap;

public class EnumMapDemo {

	public static void main(String[] args) {

		EnumMap<season, String> map = new EnumMap<season, String>(season.class);
		map.put(season.spring, "´ºÀ§");
		map.put(season.summer, "ÏÄÀ§");
		map.put(season.autumn, "ÇïÀ§");
		map.put(season.winter, "´ºÀ§");
		System.out.println(map.size());
	}

}
 enum season{
	 spring,summer,autumn,winter
 }