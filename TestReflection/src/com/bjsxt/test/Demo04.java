package com.bjsxt.test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.bjsxt.bean.User;

/**
 * 通过反射获取泛型信息
 * @ClassName: Demo04
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-18 22:35:08
 */
public class Demo04 {
	
	public  void test01(Map<String, User> map,List<User> list) {
		System.out.println("Demo04.test01");
	}

	public  Map<Integer, User>   test02() {
		System.out.println("Demo04.test02");
		return null;
	}
	public static void main(String[] args) {
		try {
			Method m= Demo04.class.getMethod("test01", Map.class,List.class);
			Type[]  t=m.getGenericParameterTypes();
			for(Type parameterType:t) {
				System.out.println("#"+parameterType);
				if(parameterType instanceof ParameterizedType) {
					Type[] genericParameterTypes=((ParameterizedType)parameterType).getActualTypeArguments();
					for(Type genericParameterType: genericParameterTypes) {
						System.out.println("泛型类型："+genericParameterType);
					}
				}
			}
			
			Method m2= Demo04.class.getMethod("test02", null);
			Type  returnType=m2.getGenericReturnType();
			
				if(returnType instanceof ParameterizedType) {
					Type[] genericParameterTypes=((ParameterizedType)returnType).getActualTypeArguments();
					for(Type genericParameterType: genericParameterTypes) {
						System.out.println("返回值，泛型类型："+genericParameterType);
					}
				}
			
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
