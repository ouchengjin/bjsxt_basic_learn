package com.bjsxt.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02 {
	/**
	 * 写出文件
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @author author
	 * @date 2020-03-29 11:31:05
	 */

	public static void main(String[] args) {
		//创建源
		File dest=new File("D:/mycode/cp/char.txt");
		//选择流
		Writer wr =null;
		try {
			wr = new FileWriter(dest,true);
			//写出
			String str= "的回复据是否活动结束发货单酸辣粉打发接口是否had开了房";
			wr.write(str);
			wr.append("哈克斯大会上就挨打卡号的");
			wr.flush();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
