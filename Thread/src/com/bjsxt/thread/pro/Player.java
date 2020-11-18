package com.bjsxt.thread.pro;
/**
 * 生产者
 * @ClassName: Player
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-14 21:15:14
 */

public class Player implements Runnable {

	private Movie m;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i =0;i<20;i++) {
			if(0==i%2) {
				m.play("左青龙"+i);
				
			}else {
				m.play("右白虎"+i);
			}
		}
		
	}

}
