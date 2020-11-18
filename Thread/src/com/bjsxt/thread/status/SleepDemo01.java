package com.bjsxt.thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.倒计时10个数，1秒打印一个
 * 2.倒计时
 * @ClassName: SleepDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-11 17:09:03
 */
public class SleepDemo01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime= new Date(System.currentTimeMillis()+10*1000);
		long end= endTime.getTime();
		while(true) {
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒时间
			endTime= new Date(endTime.getTime()-1000);
			//等待一秒
			Thread.sleep(1000);
			//十秒以内继续，否则退出
			if(end-10000 >endTime.getTime() ) {
				break;
			}
			
			
		}
	}

	public static void test1() throws InterruptedException {
//		for(int i=10;i>0;i--) {
//		Thread.sleep(1000);
//		System.out.println(i);
//	}
	int num =10;
	while(true) {
		System.out.println(num--);
		Thread.sleep(1000);//暂停
		if(num<=0) {
			break;
		}
	}
	}
}
