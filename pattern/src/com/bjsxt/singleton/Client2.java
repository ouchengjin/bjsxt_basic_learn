package com.bjsxt.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 * @ClassName: Client2
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-30 16:58:31
 */
public class Client2 {

	public static void main(String[] args) throws Exception {
		SingletonDemo6 singletonsemo61 = SingletonDemo6.getSingletonsemo6();
		SingletonDemo6 singletonsemo62 = SingletonDemo6.getSingletonsemo6();
		
		System.out.println(singletonsemo61);
		System.out.println(singletonsemo62);
		//通过反射的方式调用私有构造器
//		Class<SingletonDemo6> clazz = (Class<SingletonDemo6>) Class.forName("com.bjsxt.singleton.SingletonDemo6");
//		Constructor<SingletonDemo6> declaredConstructor = clazz.getDeclaredConstructor(null);
//		declaredConstructor.setAccessible(true);
//		SingletonDemo6 newInstance1 = declaredConstructor.newInstance();
//		SingletonDemo6 newInstance2 = declaredConstructor.newInstance();
//		System.out.println(newInstance1);
//		System.out.println(newInstance2);
		//通过反序列化的方式构造多个对象
		FileOutputStream fos = new FileOutputStream("D:\\mycode\\myjava\\a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(singletonsemo61);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("D:\\mycode\\myjava\\a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonDemo6 singletonsemo63 = (SingletonDemo6) ois.readObject();
		System.out.println(singletonsemo63);
		ois.close();
		fis.close();
	}

}
