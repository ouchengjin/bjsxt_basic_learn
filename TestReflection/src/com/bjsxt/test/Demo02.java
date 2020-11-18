package com.bjsxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名字、属性、构造器、方法）
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-15 22:24:46
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.bjsxt.bean.User";
		try {
			Class clazz = Class.forName(path);
			
			//获取类的名字
			System.out.println(clazz.getName());//获得包名+类名 com.bjsxt.bean.User
			System.out.println(clazz.getSimpleName());//获得类名 User
			
			//获得属性信息
			Field[] fields=clazz.getFields();//只能获得 public fields of the class 
			System.out.println("clazz.getFields():"+fields.length);
			
			Field[] fields2=clazz.getDeclaredFields();//获得所有的fields，This includes public, protected, default(package) access, and private fields, but excludes inherited fields
			System.out.println("clazz.getDeclaredFields():"+fields2.length);
			for(Field temp: fields2) {
				System.out.println("属性："+temp);
			}
			
			Field f=clazz.getDeclaredField("uname");
			System.out.println("属性："+f);
			//获得方法信息
			Method[] methods=clazz.getMethods();//只能获得 public fields of the class ,including those declared by the class or interface andthose inherited from superclasses and superinterfaces. 
			System.out.println("clazz.getMethods():"+methods.length);
			for(Method temp: methods) {
				System.out.println("方法："+temp);
			}
			
			Method[] methods2=clazz.getDeclaredMethods();//获得所有的methods，including public, protected, default (package)access, and private methods, but excluding inherited methods. 
			System.out.println("clazz.getDeclaredMethods():"+methods2.length);
			for(Method temp: methods2) {
				System.out.println("方法："+temp);
			}
			
			Method m=clazz.getDeclaredMethod("getId", null);//没有参数
			Method m2=clazz.getDeclaredMethod("setId", int.class);//有参数.如果方法有参数，必须传递参数类型对应的class对象
			System.out.println("getId方法："+m);
			System.out.println("setId方法："+m2);
			
			//获得构造器信息
			Constructor[] Constructors=clazz.getConstructors();//public constructors
			System.out.println("clazz.getConstructors():"+Constructors.length);
			for(Constructor temp: Constructors) {
				System.out.println("构造器："+temp);
			}
			
			Constructor[] constructors2=clazz.getDeclaredConstructors();//获得所有构造器These are public, protected, default(package) access, and private constructors.
			System.out.println("clazz.getDeclaredConstructors():"+constructors2.length);
			for(Constructor temp: constructors2) {
				System.out.println("构造器："+temp);
			}
			
			Constructor c=clazz.getDeclaredConstructor(null);//没有参数
			Constructor c2=clazz.getDeclaredConstructor(int.class);//有参int构造器
			Constructor c3=clazz.getDeclaredConstructor(int.class,int.class,String.class);//有参int构造器
			System.out.println("无参构造器："+c);
			System.out.println("有参int构造器："+c2);
			System.out.println("有参int , int , String 构造器："+c3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
