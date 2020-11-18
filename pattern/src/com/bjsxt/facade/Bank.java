package com.bjsxt.facade;

public interface Bank {
	void openAccount();//开户
}
class ZhaoShangBank implements Bank{

	@Override
	public void openAccount() {
		System.out.println("open account successful in ZhaoShangBank");
	}
	
}