package com.bjsxt.regex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 测试正则表达式对象的分割操作	
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-11 21:39:20
 */
public class Demo04 {

	public static void main(String[] args) {
		String str="ghg2323ghghj312g3h1jgh323g12h31";
		String[] split = str.split("\\d+");
		System.out.println(Arrays.toString(split));
		
	}

}
