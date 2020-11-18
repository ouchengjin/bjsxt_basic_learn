package com.bjsxt.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.print.attribute.standard.SheetCollate;

/**
 * 测试new和克隆方式的效率
 * 如果需要短时间创建大量对象，并且new的过程比较耗时，可以考虑克隆方式
 * @ClassName: Client4
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-01 22:22:02
 */
public class Client4 {
	
	public static void testNew(int size ) {
		long startTime= System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			Laptop s= new Laptop();
		}
		long endTime= System.currentTimeMillis();
		System.out.println("new :"+(endTime-startTime));
		
	}
	public static void testClone(int size ) throws CloneNotSupportedException {
		Laptop s= new Laptop();
		long startTime= System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			Laptop s1= (Laptop) s.clone();
		}
		long endTime= System.currentTimeMillis();
		System.out.println("clone :"+(endTime-startTime));
		
	}


	public static void main(String[] args) throws Exception {
		testNew(1000);
		testClone(1000);
	
	}

}

class Laptop implements Cloneable{//笔记本电脑
	public Laptop() {
		try {
			Thread.sleep(10);//模拟创建对象耗时的过程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj= super.clone();//直接调用Object的clone()方法
		return obj;
		
	}
}
