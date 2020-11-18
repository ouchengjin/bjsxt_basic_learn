package com.bjsxt.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 测试正则表达式中分组的处理
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-11 21:39:20
 */
public class Demo02 {

	public static void main(String[] args) {
		//在这个字符串fsas235515312653gsaghafha是否符合指定的正则表达式\w+
		//表达式对象
		Pattern compile = Pattern.compile("([a-z]+)([0-9]+)");
		//创建Matcher对象
		Matcher matcher = compile.matcher("uy21*hjh212*kjk21*d8d8a9");
		while(matcher.find()) {
			System.out.println(matcher.group());//group()group(0)都是表示匹配整个表达式的子字符串
//			System.out.println(matcher.group(0));//如果是group(1)group(2)表示捕获组或分组
			System.out.println(matcher.group(1));//如果是group(1)group(2)表示捕获组或分组
			System.out.println(matcher.group(2));//如果是group(1)group(2)表示捕获组或分组
		}
		
	}

}
