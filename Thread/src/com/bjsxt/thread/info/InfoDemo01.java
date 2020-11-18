package com.bjsxt.thread.info;
/**
 * Thread.currentThread() 当前线程
 * setName(String name) 设置名称
 * getName()获取名称
 * isAlive() 判断状态
 * @ClassName: InfoDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-11 20:42:50
 */
public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it= new MyThread();
		Thread proxy= new Thread(it,"挨踢");
		proxy.setName("test");
		System.out.println(Thread.currentThread().getName());//main
		
		proxy.start();
		System.out.println("启动后的状态"+proxy.isAlive());
		Thread.sleep(200);
		it.stop();//cpu并不会马上停止，会有延缓的时间
		Thread.sleep(100);
		System.out.println("停止后的状态"+proxy.isAlive());

	}

}
