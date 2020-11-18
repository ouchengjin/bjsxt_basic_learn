package com.bjsxt.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @ClassName: Demo03
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-14 20:53:30
 */
public class Demo03 {
	
	public static void main(String[] args) {
		try {
			Class<?> clz= Class.forName("com.bjsxt.test.annotation.SxtStudent");
			//获得类的所有有效注解
			Annotation[]  annotations=clz.getAnnotations();
			for(Annotation temp:annotations) {
				System.out.println(temp);
			}
			//获得类的指定注解
			SxtTable st= clz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			//获得类的属性的注解
			Field  f=clz.getDeclaredField("studentName");
			SxtField SxtField= f.getAnnotation(SxtField.class);
			System.out.println(SxtField.columnName()+"----"+SxtField.type()+"-----"+SxtField.length());
			//根据获得的表名，字段的信息拼出DDL语句，然后用JDBC执行这个sql，在数据库中生成相应的表
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
