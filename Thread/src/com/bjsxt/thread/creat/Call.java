package com.bjsxt.thread.creat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 使用Callable创建线程
 * @ClassName: Call
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-09 22:56:42
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//创建线程
		ExecutorService ser =Executors.newFixedThreadPool(2);
		Race tortoise= new Race("老不死",1000);
		Race rabbit= new Race("小兔子",500);
		//获取值
		Future<Integer> result1 = ser.submit(tortoise);
		Future<Integer> result2 = ser.submit(rabbit);
		
		Thread.sleep(2000);//2秒
		tortoise.setFlag(false);//停止线程体循环
		rabbit.setFlag(false);
		
		
		
		
		int num1 = result1.get();
		int num2 = result2.get();
		System.out.println("tortoise run---"+num1+"steps");
		System.out.println("rabbit run---"+num2+"steps");
		 //停止服务
		 ser.shutdownNow();
}
}
class Race implements Callable<Integer>{

	private String name;//名称
	private long time;//延时时间
	private boolean flag=true;
	private int step=0;//步
	public Race() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Race(String name) {
		super();
		this.name = name;
	}
	



	


	public Race(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}



	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while(flag) {
			Thread.sleep(time);//延时
			step++;
		}
		return step;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getTime() {
		return time;
	}



	public void setTime(long time) {
		this.time = time;
	}



	public boolean isFlag() {
		return flag;
	}



	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	public int getStep() {
		return step;
	}



	public void setStep(int step) {
		this.step = step;
	}



	
	
	
}
