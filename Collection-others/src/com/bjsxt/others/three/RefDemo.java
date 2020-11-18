package com.bjsxt.others.three;

import java.lang.ref.WeakReference;

public class RefDemo {

	public static void main(String[] args) {

		String str = new String("bjsxt is very good");
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc����ǰ:"+wr.get());
		str =null;
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�:"+wr.get());

	}
	
	public static void testStrong() {
		String str = "bjsxt is very good";
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc����ǰ:"+wr.get());
		str =null;
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�:"+wr.get());
		
	}
}
