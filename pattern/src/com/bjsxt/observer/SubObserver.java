package com.bjsxt.observer;

public class SubObserver implements Observer {
	private String name;
	private String myState;//myState需要和目标对象的state值保持一致
	
	public SubObserver(String name) {
		super();
		this.name = name;
	}

	@Override
	public void register(Subject subject) {
		subject.registerObserver(this);
		System.out.println("登记成功");

	}
	
	@Override
	public void update(Subject subject) {
		myState=((ConcreteSubject)subject).state;
		System.out.println(name+"状态是："+myState);
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}

	
}
