package com.bjsxt.singleton;
/**
 * 测试枚举式实现单例模式（无延时加载）
 * @ClassName: SingletonDemo4
 * @Description:
 * @author Alan Ouyang
 * @date 2020-05-30 16:10:22
 */
public enum SingletonDemo5 {
	//这个枚举元素本身就是单例对象
	instance;
	//添加自己需要的操作
	public void singletonOperation() {
		
	}
	
}
