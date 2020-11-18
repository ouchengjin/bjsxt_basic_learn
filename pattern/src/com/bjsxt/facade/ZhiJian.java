package com.bjsxt.facade;

public interface ZhiJian {
	void zhiJian();
}

class HaidianquZhiJianJu implements ZhiJian{

	@Override
	public void zhiJian() {
		System.out.println("质检通过");
		
	}
	
}
