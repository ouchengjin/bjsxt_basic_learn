package com.bjsxt.thread.status;

public class YieldDemo01 extends Thread{

	public static void main(String[] args) {
		YieldDemo01 demo = new YieldDemo01();
		Thread t= new Thread(demo);//新生
		t.start();//调度
		//cpu调度运行
		
		
		for(int i=0;i<100;i++) {
			System.out.println("main..."+i);
			if(i%20==0) {
				//暂停本线程main，写在哪个线程里就暂停谁
				
				Thread.yield();//效果不是很明显，理解就行，能不能暂停就看cpu了
			}
			
		}

	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("yield..."+i);
		}
	}
}
