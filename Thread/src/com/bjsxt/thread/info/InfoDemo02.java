package com.bjsxt.thread.info;
/**
 * 优先级：是概率，不是绝对的先后顺序
    static int MAX_PRIORITY  10
	          线程可以具有的最高优先级。 
	static int MIN_PRIORITY   5（默认）
	          线程可以具有的最低优先级。 
	static int NORM_PRIORITY   1
	          分配给线程的默认优先级。 
	setPriority(int newPriority) 
          更改线程的优先级。
    getPriority() 
          返回线程的优先级。

 * @ClassName: InfoDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-11 22:06:24
 */
public class InfoDemo02 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it= new MyThread();
		Thread p1= new Thread(it,"挨踢1");
		MyThread it2= new MyThread();
		Thread p2= new Thread(it2,"挨踢2");
		
		p1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);//设置优先级，代表被cpu调用概率，不代表先后顺序
		System.out.println(p1.getPriority());
		System.out.println(p2.getPriority());
		p1.start();
		p2.start();
		Thread.sleep(200);
		it.stop();
		it2.stop();

	}

}
