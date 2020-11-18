package com.bjsxt.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bjsxt.test.annotation.SxtField;
import com.bjsxt.test.annotation.SxtMethod;
import com.bjsxt.test.annotation.SxtStudent;
import com.bjsxt.test.annotation.SxtTable;

/**
 * 通过反射获取注解信息
 * @ClassName: Demo05
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-19 21:14:22
 */
public class Demo05 {

	public static void main(String[] args) {

		try {
			Class<?> clazz = Class.forName("com.bjsxt.test.annotation.SxtStudent");
			//获取类的所有的有效注解
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation annotation: annotations) {
				System.out.println(annotation);
				
			}
			//获得类的指定的
			SxtTable st=(SxtTable)clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			//获得类的属性的注解
			Field  f=clazz.getDeclaredField("studentName");
			SxtField sxtField =f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"------"+sxtField.type()+"-------"+sxtField.length());
			
			//根据获得的表名、字段的信息，拼出DDL语句，然后使用jdbc执行这个SQL，在数据库中生成相关的表
			
			//获取类的方法的注解
			Method method=clazz.getDeclaredMethod("getStudentName", null);
			SxtMethod sxtMethod=method.getAnnotation(SxtMethod.class);
			System.out.println(sxtMethod.columnName()+"------"+sxtMethod.type()+"------"+sxtMethod.length());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
