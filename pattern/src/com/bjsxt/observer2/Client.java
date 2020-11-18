package com.bjsxt.observer2;

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
		//观察者注册到目标对象中的容器中
		concreteSubject.addObserver(subObserver1);
		concreteSubject.addObserver(subObserver2);
		concreteSubject.addObserver(subObserver3);
		concreteSubject2.addObserver(subObserver4);
		//改变subject的状态
		concreteSubject.setState("广播");
		concreteSubject2.setState("哈哈");
		concreteSubject.setState("广播22");
	}

}
