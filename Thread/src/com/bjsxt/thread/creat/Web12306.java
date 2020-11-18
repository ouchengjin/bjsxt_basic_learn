package com.bjsxt.thread.creat;
/**
 * 方便共享资源
 * @ClassName: Web12306
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-09 22:30:01
 */
public class Web12306 implements Runnable{

	private int num = 50;

	@Override
	public void run() {
		while(true) {
			if(num<=0) {
				break;//跳出循环
			}else {
				System.out.println(Thread.currentThread().getName()+"恭喜抢到了"+num--);
			}
		}
		
	}
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		Thread t1= new Thread(web, "路人甲");
		Thread t2 = new Thread(web,"黄牛乙");
		Thread t3 = new Thread(web,"工程师");
		t1.start();
		t2.start();
		t3.start();
	}
}
