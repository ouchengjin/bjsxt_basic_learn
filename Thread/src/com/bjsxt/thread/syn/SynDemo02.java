package com.bjsxt.thread.syn;
/**
 * 单例设计模式：确保外部使用时一个类只有一个对象，类内部创建，外部只能使用这一个对象
 * @ClassName: SynDemo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-12 22:35:33
 */
public class SynDemo02 {

	public static void main(String[] args) {
		JvmThread thread1= new JvmThread(100);
		JvmThread thread2= new JvmThread(500);
		thread1.start();
		thread2.start();
		
		

	}

}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {
		
	}
	
	public JvmThread(long time) {
		super();
		this.time = time;
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->创建"+Jvm.getInstance(time));
	}
}

/**
 * 单例设计模式
 * 确保一个类只有一个对象 
 * 懒汉式 双重检查 double checking	（经典）
 * 1.构造器私有化，避免外部直接创造对象
 * 2.声明一个私有的静态变量
 * 3.创建一个对外的公共的静态方法访问该变量，如果该变量没有对象，创建该对象
 * @ClassName: Jvm
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-13 12:06:58
 */
class Jvm{
//	声明一个私有的静态变量
	private static Jvm instance=null;//这块懒的创建对象，所以称为懒汉式，静态的代表只有一份
	
	//构造器私有化，避免外部直接创造对象
	private Jvm() {
		// TODO Auto-generated constructor stub
	}
	//创建一个对外的公共的静态方法访问该变量，如果该变量没有对象，创建该对象
		public static  Jvm getInstance(long time) {
			if(null==instance) {//为了提高效率
					synchronized (Jvm.class){//静态方法里没有this，this是成员函数中的;此处为类的字节码信息，类的模板
					if(null==instance) {
						try {
							Thread.sleep(time);//放大错误的概率
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						instance= new Jvm();
					}
					
					}
				}	
			return instance;
		}
	//创建一个对外的公共的静态方法访问该变量，如果该变量没有对象，创建该对象
		public static  Jvm getInstance3(long time) {
			//线程在此等待，效果等同getInstance2，效率不高（存在对象也需要等待）
			synchronized (Jvm.class){//静态方法里没有this，this是成员函数中的;此处为类的字节码信息，类的模板
			if(null==instance) {
				try {
					Thread.sleep(time);//放大错误的概率
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance= new Jvm();
			}
			
			return instance;
			}
		}
	//创建一个对外的公共的静态方法访问该变量，如果该变量没有对象，创建该对象
	public static synchronized Jvm getInstance2(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);//放大错误的概率
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
		
		return instance;
	}
	//创建一个对外的公共的静态方法访问该变量，如果该变量没有对象，创建该对象
		public static  Jvm getInstance1(long time) {
			if(null==instance) {
				try {
					Thread.sleep(time);//放大错误的概率
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance= new Jvm();
			}
			
			return instance;
		}
	
}
