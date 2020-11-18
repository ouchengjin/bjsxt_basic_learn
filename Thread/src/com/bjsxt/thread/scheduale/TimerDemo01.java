package com.bjsxt.thread.scheduale;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 了解
 * Timer()
 *  void schedule(TimerTask task, Date time) 
          安排在指定的时间执行指定的任务。 
 void schedule(TimerTask task, Date firstTime, long period) 
          安排指定的任务在指定的时间开始进行重复的固定延迟执行。 
    自学一下quartz

 * @ClassName: TimerDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-14 22:14:51
 */
public class TimerDemo01 {

	public static void main(String[] args) {
		Timer timer= new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("so easy....");
				
			}
		}, new Date(System.currentTimeMillis()+1000), 100);

	}

}
