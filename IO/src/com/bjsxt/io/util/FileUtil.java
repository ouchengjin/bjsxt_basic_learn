package com.bjsxt.io.util;

import java.io.Closeable;

public class FileUtil {
	/**
	 * 工具类关闭流
	 * 可变参数：...  只能形参最后一个位置
	 */
	public static void close(Closeable ... io) {
		for(Closeable temp:io) {
//			alt+shift+z
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/**
	 * 泛型
	 */
	public static <T extends Closeable> void closeAll(T ... io) {
		for(Closeable temp:io) {
//			alt+shift+z
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
