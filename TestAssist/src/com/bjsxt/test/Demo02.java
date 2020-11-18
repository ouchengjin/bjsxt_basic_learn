package com.bjsxt.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;

/**
 * 测试javassist的API
 * @ClassName: Demo02
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-23 21:07:37
 */
public class Demo02 {
	/**
	 * 处理类的基本用法,
	 * @Title: test01
	 * @Description: TODO(描述)
	 * @author author
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IOException 
	 * @date 2020-05-23 21:12:05
	 */
	public static void test01() throws NotFoundException, IOException, CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc=pool.get("com.bjsxt.test.Emp");//获得已有的类
		byte[] bytes= cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println(cc.getName());          //获取类名
		System.out.println(cc.getSimpleName());    	//获取简要类名
		System.out.println(cc.getSuperclass());		//获取父类
		System.out.println(cc.getInterfaces());		//获取接口
	}
	/**
	 * 处理方法的基本用法，测试产生新的方法
	 * @Title: test02
	 * @Description: TODO(描述)
	 * @author author
	 * @throws Exception 
	 * @date 2020-05-23 21:46:07
	 */
	public static void test02() throws Exception  {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc=pool.get("com.bjsxt.test.Emp");//获得已有的类
//		CtMethod m= CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
		//下面实现了上行一样的效果
		CtMethod m= new CtMethod(CtClass.intType, "add", new CtClass[] {CtClass.intType,CtClass.intType}, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"OUCHENGJIN\");return $1+$2;}");
		cc.addMethod(m);
		//通过反射调用新生成的方法
		Class<?> clazz=cc.toClass();
		Object obj =clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
//		Method m2=clazz.getMethod("add", int.class,int.class);
		Method m2=clazz.getDeclaredMethod("add", int.class,int.class);
		Object result =m2.invoke(obj, 10,20);
		System.out.println(result);	
	}
	//获取已有的方法，并修改方法体的内容
	public static void test03() throws Exception  {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc=pool.get("com.bjsxt.test.Emp");//获得已有的类
		CtMethod cm=cc.getDeclaredMethod("sayHello",new CtClass[] {CtClass.intType} );
		cm.insertBefore("System.out.println($1);System.out.println(\"start\");");
		cm.insertAfter("System.out.println(\"end\");");
		cm.insertAt(34, "int b=3;System.out.println(\"b=\"+b);");//在这行之前插入
		
		//通过反射调用新生成的方法
		Class<?> clazz=cc.toClass();
		Object obj =clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
//		Method m2=clazz.getMethod("add", int.class,int.class);
		Method m2=clazz.getDeclaredMethod("sayHello", int.class);
		m2.invoke(obj, 10);
	}
	//修改参数,属性的操作
	public static void test04() throws Exception  {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc=pool.get("com.bjsxt.test.Emp");//获得已有的类
//		CtField f1= CtField.make("private int empNo", cc);
		CtField f2= new CtField(CtClass.intType, "empNo2", cc);
		f2.setModifiers(Modifier.PRIVATE);
		cc.addField(f2, "100");//默认值
//		cc.addField(f2);
//		CtField field=cc.getDeclaredField("empNo2");//获取指定的属性
		//获取相应的set，get方法
		CtMethod f3=CtNewMethod.setter("setEmpNo2",f2 );
		CtMethod f4=CtNewMethod.getter("getEmpNo2",f2 );
		cc.addMethod(f3);
		cc.addMethod(f4);
		//通过反射调用新生成的方法
		Class<?> clazz=cc.toClass();
		Object obj =clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
//		Method m2=clazz.getMethod("add", int.class,int.class);
		Method m2=clazz.getDeclaredMethod("getEmpNo2");
		Object result=m2.invoke(obj, null);
		System.out.println(result);
		
	}
	//构造器方法的操作
	public static void test05() throws Exception  {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc=pool.get("com.bjsxt.test.Emp");//获得已有的类
		CtConstructor[] constructors=cc.getConstructors();
		for(CtConstructor constructor :constructors) {
			System.out.println(constructor.getLongName());//在构造器里也可以用insertat插入
		}
	}
	//注解
	public static void test06() throws Exception {
		ClassPool pool= ClassPool.getDefault();
		CtClass cc= pool.get("com.bjsxt.test.Emp");
		Object[] all=cc.getAnnotations();
		Author a=(Author) all[0];
		String name=a.name();
		int year=a.year();
		System.out.println("name:"+name+",year:"+year);
		
	}
	
	public static void main(String[] args) {
		try {
//			test01();
//			test02();
//			test03();
//			test04();
//			test05();
			test06();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	}
	
}
