package com.bjsxt.observer2;

import java.util.Observable;
import java.util.Observer;

public class SubObserver implements Observer {
	private String name;
	private String myStates;
	
	
	public SubObserver(String name) {
		super();
		this.name = name;
	}



	@Override
	public void update(Observable o, Object arg) {
		myStates=((ConcreteSubject)o).getState();
		System.out.println(name+"状态是"+myStates);
		
	}



	public String getMyStates() {
		return myStates;
	}



	public void setMyStates(String myStates) {
		this.myStates = myStates;
	}
	
	
}
