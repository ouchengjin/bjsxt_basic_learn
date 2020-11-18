package com.bjsxt.others.que;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {

	public static void main(String[] args) {
		Queue<Request> que =new ArrayDeque<Request>();
		for (int i=0;i<10; i++) {
			final int number = i;
			que.offer(new Request() {
				
				@Override
				public void deposit() {

					System.out.println("��"+(number+1)+"���ˣ�������ҵ�񣬴����Ϊ��"+Math.random()*10000);
				}
			});
		}
		
		dealwith(que);
	}
	
	public static void dealwith(Queue<Request> que) {
		Request req =null;
		while(null!=(req=que.poll())) {
			req.deposit();
		}
	}
}
interface Request {
	void deposit();
}
