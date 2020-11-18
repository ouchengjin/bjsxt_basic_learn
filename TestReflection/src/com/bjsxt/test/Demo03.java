package com.bjsxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bjsxt.bean.User;

/**
 * 通过反射API动态操作：构造器，方法，属性，
 * @ClassName: Demo03
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-17 18:33:50
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "com.bjsxt.bean.User";
		try {
//			Class clazz = Class.forName(path);
//			//通过反射API调用构造方法，构造对象
//			User u= (User) clazz.newInstance();
			
			Class<User> clazz = (Class<User>) Class.forName(path);
			//通过反射API调用构造方法，构造对象
			User u=  clazz.newInstance();//其实是调用了User的无参构造方法
			System.out.println(u);
//			Constructor<User> c= clazz.getConstructor(int.class,int.class,String.class);
//			User u2=c.newInstance(1,18,"ouchengjin");
			Constructor c= clazz.getConstructor(int.class,int.class,String.class);
			User u2=(User) c.newInstance(1,18,"ouchengjin");
			System.out.println(u2.getUname());
			
			//通过反射API调用普通方法
			User u3=(User) clazz.newInstance();
			Method method= clazz.getDeclaredMethod("setUname",String.class);
			//上行和下行的方法名和参数内容都是变量。所以可以从其他地方传过来，别人给我传什么，就执行什么，这就是反射的好处（动态的调用）
//			method.setAccessible(true);//若该方法method是private，可以用本句省略安全检查
			method.invoke(u3, "ouchengjin2");//相当于u3.setUname("ouchengjin2");
			System.out.println(u3.getUname());
			
			//通过反射API操作属性
			User u4=(User) clazz.newInstance();
			Field field= clazz.getDeclaredField("uname");
			field.setAccessible(true);//不做安全检查。为了接下来的private属性赋值。（setAccessible在上面的方法中同样适用）
			field.set(u4, "ouchengjin3");//通过反射直接写属性
			System.out.println(u4.getUname());//通过对象调用方法
			System.out.println(field.get(u4));//通过反射调用
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
