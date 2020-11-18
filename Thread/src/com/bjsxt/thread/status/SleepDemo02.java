package com.bjsxt.thread.status;



/**
 * sleep模拟网络延迟 线程不安全的类
 * @ClassName: SleepDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-11 20:05:55
 */
public class SleepDemo02 {

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

class Web12306 implements Runnable{

	private int num = 50;

	@Override
	public void run() {
		while(true) {
			if(num<=0) {
				break;//跳出循环
			}else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
			}
		}
		
	}

}

