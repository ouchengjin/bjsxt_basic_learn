package com.bjsxt.observer2;

import java.util.Observable;
//目标对象
public class ConcreteSubject extends Observable {
	private String  state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;//目标对象状态发生了改变
		setChanged();//目标对象已经做了更改
		notifyObservers(state);//通知所有的观察者 
	}
	
}
