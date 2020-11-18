package com.bjsxt.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 测试正则表达式的基本用法
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-11 21:39:20
 */
public class Demo01 {

	public static void main(String[] args) {
		//在这个字符串fsas235515312653gsaghafha是否符合指定的正则表达式\w+
		//表达式对象
		Pattern compile = Pattern.compile("\\w+");
		//创建Matcher对象
		Matcher matcher = compile.matcher("fsas235515312&&653gsaghafha");
//		boolean matches = matcher.matches();//尝试将整个字符串序列与该模式匹配
//		System.out.println(matches);
//		boolean find = matcher.find();//该方法扫描输入的序列查找与该模式匹配的下一个子序列
//		System.out.println(find);
		
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
		while(matcher.find()) {
			System.out.println(matcher.group());//group()group(0)都是表示匹配整个表达式的子字符串
			System.out.println(matcher.group(0));//如果是group(1)group(2)表示捕获组或分组
		}
		
	}

}
