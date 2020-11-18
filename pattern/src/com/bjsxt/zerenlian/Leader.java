package com.bjsxt.zerenlian;
//抽象类
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;//责任链上的后继对象
	public Leader() {
	}
	
	public Leader(String name) {
		super();
		this.name = name;
	}
	//处理请求的核心业务方法
	public abstract void doRequest(Request request);

	public Leader getNextLeader() {
		return nextLeader;
	}
	//设定责任链上的后继对象
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	
}

