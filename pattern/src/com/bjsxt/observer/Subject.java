package com.bjsxt.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	protected List<Observer> observers= new ArrayList<Observer>();
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	//通知所有的观察者更新状态
	public void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
