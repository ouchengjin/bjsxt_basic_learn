package com.bjsxt.thread.syn;



public class SynDemo01 {

	public static void main(String[] args) {
		//真实角色
		Web12306 web = new Web12306();
		//代理
		Thread t1= new Thread(web, "路人甲");
		Thread t2 = new Thread(web,"黄牛乙");
		Thread t3 = new Thread(web,"工程师");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}

}
//线程安全的类
class Web12306 implements Runnable{

	private int num = 10;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test6();
		}
		
	}
	//线程不安全 锁定资源不正确
			public void test6() {
				
					if(num<=0) {
						flag=false;//跳出循环
						return;
					}else {
					//线程在此等待
					synchronized(this) {
//						try {
//							Thread.sleep(500);//模拟延时
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
					}
				}
			}
	//线程不安全 锁定资源不正确
		public void test5() {
			//线程在此等待
			synchronized((Integer)num) {
				if(num<=0) {
					flag=false;//跳出循环
					return;
				}else {
					try {
						Thread.sleep(500);//模拟延时
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
				}
			}
		}
	//锁定范围不正确 线程不安全
	public void test4() {
		//线程在此等待
		synchronized(this) {
			if(num<=0) {
				flag=false;//跳出循环
				return;
			}
		}
				try {
					Thread.sleep(500);//模拟延时
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
		
	}
	
	//线程安全 锁定正确
	public void test3() {
		//线程在此等待
		synchronized(this) {
			if(num<=0) {
				flag=false;//跳出循环
				return;
			}else {
				try {
					Thread.sleep(500);//模拟延时
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
			}
		}
	}
	//线程安全 锁定正确
	public synchronized void test2() {
		if(num<=0) {
			flag=false;//跳出循环
			return;
		}else {
			try {
				Thread.sleep(500);//模拟延时
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
		}
	}
	//线程不安全
	public void test1() {
		if(num<=0) {
			flag=false;//跳出循环
			return;
		}else {
			try {
				Thread.sleep(500);//模拟延时
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
		}
	}

}

