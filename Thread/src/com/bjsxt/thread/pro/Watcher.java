package com.bjsxt.thread.pro;
/**
 * 消费者
 * @ClassName: Watcher
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-14 21:15:44
 */
public class Watcher implements Runnable {
	private Movie m;
	
	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
		m.watch();
		}
	}

}