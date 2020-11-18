package com.bjsxt.thread.status;
/**
 * join:合并线程
 * @ClassName: JoinDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-11 15:49:53
 */
public class JoinDemo01 extends Thread{
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo = new JoinDemo01();
		Thread t= new Thread(demo);//新生
		t.start();//调度
		//cpu调度运行
		
		
		for(int i=0;i<100;i++) {
			System.out.println("main..."+i);
			if(25==i) {
				t.join();//main阻塞，要等t这个线程执行完再继续接下来的代码
			}
			
		}
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("join..."+i);
		}
	}

}
