package com.bjsxt.io.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.bjsxt.io.util.FileUtil;


/**
 * 文件分割的思路
 * 1.分割的块数size n块
 * 2.每一块的大小blockSize
 * 最后一块大小：总得文件大小-（n-1）*blockSize
 * @ClassName: RndDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-05 19:46:09
 */
public class RndDemo01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rnd = new RandomAccessFile(new File("D:/mycode/cp/Demo04.java"),"r");
		//定义缓冲大小
		rnd.seek(100);
		byte[] flush = new byte[1024];
		//接收长度
		int len = 0;
		while(-1!=(len = rnd.read(flush))) {
			if(len>=200) {
				System.out.println(new String(flush,0, 200));
				break;
				
			}else {
				System.out.println(new String(flush,0,len));
			}
		}
		FileUtil.closeAll(rnd);

	}

}
