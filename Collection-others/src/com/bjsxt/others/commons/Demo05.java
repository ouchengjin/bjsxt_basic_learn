package com.bjsxt.others.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue����
 * ѭ������
 * ֻ�����У����ɸı����
 * @ClassName: Demo05
 * @Description: TODO(����)
 * @author author
 * @date 2020-03-08 15:40:00
 */
public class Demo05 {

	public static void main(String[] args) {
//		circular();
//		readOnly();
		predicate();
	}
	/**
	 * ���Զ���
	 * @Title: predicate
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-08 15:56:59
	 */
	public static void predicate() {
		//ѭ������
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull= NotNullPredicate.INSTANCE;
		//��װ�ɶ�Ӧ�Ķ���
		Queue<String> que2=PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);	
		
		

	}
	
	/**
	 * ֻ������
	 * @Title: readOnly
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-08 15:50:58
	 */
	public static void readOnly() {
		//ѭ������
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnlyQue=UnmodifiableQueue.unmodifiableQueue(que);
		
		readOnlyQue.add("ss");
	}
	/**
	 * ѭ������
	 * @Title: circular
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-08 15:41:33
	 */
	public static void circular() {
		//ѭ������
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		//�鿴
		for(int i=0;i<que.size();i++)
		{
			System.out.println(que.get(i));
		}
	}
}
