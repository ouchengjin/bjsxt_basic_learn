package com.bjsxt.command;
//调用者（发起者）
public class Invoke {
	private Command command;//也可以用容器list容纳很多命令对象，进行批处理。数据库底层的事务管理就是类似的结构
	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//业务方法，由于调用命令类的方法
	public void call() {
		//可以在调用命令前后做处理，如果存命令用的是list，可以在这做个拼接做个批处理
		command.execute();
	}
	
}
