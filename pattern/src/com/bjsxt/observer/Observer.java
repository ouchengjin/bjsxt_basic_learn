package com.bjsxt.observer;

public interface Observer {
	void register(Subject subject);
	void update(Subject subject);

}
