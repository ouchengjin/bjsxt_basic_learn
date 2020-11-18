package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装输入
 * @ClassName: BuffereIn
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-04 20:52:04
 */
public class BuffereIn {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		BufferedReader br= new BufferedReader(new InputStreamReader(is));
		System.out.println("please input:");
		System.out.println(br.readLine());
	}

}
