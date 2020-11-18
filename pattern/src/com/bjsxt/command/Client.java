package com.bjsxt.command;


public class Client {

	public static void main(String[] args) {
		Command concreteCommand = new ConcreteCommand(new Receiver());
		
		Invoke invoke = new Invoke(concreteCommand);
		invoke.call();
		
	}
}
