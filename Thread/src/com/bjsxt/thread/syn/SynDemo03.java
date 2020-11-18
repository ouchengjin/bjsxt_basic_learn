package com.bjsxt.thread.syn;
/**
 * 过多的同步方法可能造成死锁，锁住什么就保证什么在定义域内被单一线程专用
 * 解决死锁问题，用生产者消费者模式
 * @ClassName: SynDemo03
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-13 22:41:43
 */
public class SynDemo03 {

	public static void main(String[] args) {
		Object goods= new Object();
		Object money= new Object();
		
		Test t1= new Test(goods,money);
		Test2 t2= new Test2(goods,money);
		Thread proxy = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy.start();
		proxy2.start();
	}
}
class Test implements Runnable{
	Object goods;
	Object money;
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true){
			test();
		}
		
	}
	public void test() {
		synchronized(goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(money) {
				
			}
		}
		System.out.println("一手给钱");
	}
}

class Test2 implements Runnable{
	Object goods ;
	Object money;
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true){
			test();
		}
		
	}
	public void test() {
		synchronized(money) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(goods) {
				
			}
		}
		System.out.println("一手给货");
	}
}