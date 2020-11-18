package com.bjsxt.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 测试懒汉式单例模式（如何防止反射和反序列化漏洞）
 * @ClassName: SingletonDemo2
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-05-29 22:53:45
 */
public class SingletonDemo6 implements Serializable{
	//类初始化时不初始化这个对象（延时加载，真正用的时候再加载）
	private static SingletonDemo6 instance;
	//私有化构造器
	private SingletonDemo6() {
		//规避通过反射的方式调用私有构造器
		if(instance!=null) {
			throw new RuntimeException("不允许重复创建对象");
		}
	}

	//方法同步，调用效率低
	public  static synchronized SingletonDemo6 getSingletonsemo6() {
		if(instance==null) {
			instance= new SingletonDemo6();
		}
		return instance;
	}
	//定义了readResolve方法后，反序列化时，直接将已创建对象返回，防止创建新的对象
	//杜绝反序列化生成新的对象
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
}
