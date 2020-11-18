package com.bjsxt.facade;

public interface GongShangJu {
	void checkName();//核名
}
class HandianquGongShangJu implements GongShangJu{

	@Override
	public void checkName() {
		System.out.println("检查名字是否有冲突");
		
	}
	
}
