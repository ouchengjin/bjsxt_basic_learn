package com.bjsxt.thread.status;

public class StopDemo01 {

	public static void main(String[] args) {
		Study s= new Study();
		new Thread(s).start();
		for(int i=0;i<100;i++) {
			if(i==50) {
				s.stop();
			}
			System.out.println("main....."+i);
		}
		
	}
}
class Study implements Runnable{
//	 1)、线程类中 定义 线程体使用的标识
	private boolean flag = true;
	@Override
	public void run() {
		// //	2)、线程体使用该标识
		while(flag) {
			System.out.println("study thread.....");
		}
		
	}
//	3)、提供对外的方法改变该标识
	public void stop() {
		this.flag=false;
	}
}