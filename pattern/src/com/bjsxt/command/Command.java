package com.bjsxt.command;

public interface Command {
	//这个方法是返回值为空的方法
	//实际项目中，可以根据需求设计多个不同的方法
	void execute ();
}

class ConcreteCommand implements Command{
	private Receiver receiver;//命令真正执行者
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//命令真正执行前或后，执行相关的处理
		receiver.action();
	}
	
}