package com.bjsxt.state;
//房间对象
public class HomeContext {
	//如果是银行系统，这个Context类就是账号。根据金额不同切换不同的状态
	private State state;
	public void setzhuangtaijiekou(State zhuangtaijiekou) {
		//修改状态
		this.state=zhuangtaijiekou;
		zhuangtaijiekou.handle();
	}
}
