package com.bjsxt.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.bjsxt.bean.User;
/**
 * setAccessible(true);//不需要访问安全检查，提高效率
 * @ClassName: Demo06
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-18 22:32:13
 */
public class Demo06 {
	
	public static void test01() {
		User u =new User();
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++) {
			u.getUname();
		}
		
		long endTime=System.currentTimeMillis();
		System.out.println("普通方法调用，执行1000000000次，耗时："+(endTime-startTime)+"ms");
	}
	
	public static void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> clazz = Class.forName("com.bjsxt.bean.User");
//		User u=(User) clazz.newInstance();
		User u=new User();
		Method method = clazz.getDeclaredMethod("getUname", null);
		
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++) {
			method.invoke(u, null);
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射动态方法调用，执行1000000000次，耗时："+(endTime-startTime)+"ms");
	}
	
	public static void test03() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> clazz = Class.forName("com.bjsxt.bean.User");
//		User u=(User) clazz.newInstance();
		User u=new User();
		Method method = clazz.getDeclaredMethod("getUname", null);
		
		long startTime=System.currentTimeMillis();
		method.setAccessible(true);//不需要访问安全检查
		for(int i=0;i<1000000000L;i++) {
			method.invoke(u, null);
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射动态方法调用，跳过安全检查执行1000000000次，耗时："+(endTime-startTime)+"ms");
	}

	public static void main(String[] args) {
		
		test01();
		try {
			test02();
			test03();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
