package com.bjsxt.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 测试正则表达式对象的替换操作	
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-11 21:39:20
 */
public class Demo03 {

	public static void main(String[] args) {
		//在这个字符串fsas235515312653gsaghafha是否符合指定的正则表达式\w+
		//表达式对象
		Pattern compile = Pattern.compile("[0-9]");
		//创建Matcher对象
		Matcher matcher = compile.matcher("uy21*hjh212*kjk21*d8d8a9");
		//替换
		String replaceAll = matcher.replaceAll("#");
		System.out.println(replaceAll);
		
	}

}
