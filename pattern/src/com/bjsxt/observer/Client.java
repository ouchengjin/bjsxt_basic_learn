package com.bjsxt.observer;

public class Client {

	public static void main(String[] args) {
//		目标对象
		ConcreteSubject concreteSubject = new ConcreteSubject();
		ConcreteSubject concreteSubject2 = new ConcreteSubject();
//		创建观察者
		SubObserver subObserver1 = new SubObserver("lao1");
		SubObserver subObserver2 = new SubObserver("lao2");
		SubObserver subObserver3 = new SubObserver("lao3");
		SubObserver subObserver4 = new SubObserver("lao4");
		//观察者注册到目标对象中
		subObserver1.register(concreteSubject);
		subObserver2.register(concreteSubject);
		subObserver3.register(concreteSubject);
		subObserver4.register(concreteSubject2);
		//改变subject的状态
		concreteSubject.setStates("广播");
		concreteSubject2.setStates("哈哈");
	}

}
