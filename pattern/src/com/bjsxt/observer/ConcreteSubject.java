package com.bjsxt.observer;

public class ConcreteSubject extends Subject {
	protected String state;
	//主题对象（目标对象）值发生了变化，请通知所有的观察者
	public void setStates(String states) {
		this.state=states;
		this.notifyAllObserver();
	}
	
}
