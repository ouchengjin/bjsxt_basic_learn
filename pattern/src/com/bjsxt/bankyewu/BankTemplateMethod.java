package com.bjsxt.bankyewu;

public abstract class BankTemplateMethod {
	//具体方法
	public void paihao() {
		System.out.println("取号排队");
	}
	public abstract void transact();//办理具体的业务    //钩子方法
	public void pingjia() {
		System.out.println("反馈评分");
	}
	
	public void process() {//模板方法
		this.paihao();
		this.transact();
		this.pingjia();
	}
}
