package com.bjsxt.net.tcp.chat.demo03;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 * @ClassName: CloseUtil
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-22 22:14:25
 */
public class CloseUtil {
	
	public static void closeAll(Closeable ... closeables) { 
		for(Closeable temp:closeables) {
			if(null!= temp) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
