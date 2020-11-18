package com.bjsxt.others.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue队列
 * 循环队列
 * 只读队列：不可改变队列
 * @ClassName: Demo05
 * @Description: TODO(描述)
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
	 * 断言队列
	 * @Title: predicate
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-08 15:56:59
	 */
	public static void predicate() {
		//循环队列
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull= NotNullPredicate.INSTANCE;
		//包装成对应的队列
		Queue<String> que2=PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);	
		
		

	}
	
	/**
	 * 只读队列
	 * @Title: readOnly
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-08 15:50:58
	 */
	public static void readOnly() {
		//循环队列
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnlyQue=UnmodifiableQueue.unmodifiableQueue(que);
		
		readOnlyQue.add("ss");
	}
	/**
	 * 循环队列
	 * @Title: circular
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-08 15:41:33
	 */
	public static void circular() {
		//循环队列
		CircularFifoQueue<String> que= new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		//查看
		for(int i=0;i<que.size();i++)
		{
			System.out.println(que.get(i));
		}
	}
}
