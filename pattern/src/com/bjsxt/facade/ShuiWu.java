package com.bjsxt.facade;

public interface ShuiWu {
	void banShui();//办理税务登记证
}
class ShuiWuJu implements ShuiWu{

	@Override
	public void banShui() {
		System.out.println("在海淀税务局办理税务登记证");
		
	}
	
}