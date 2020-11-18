package com.bjsxt.bankyewu;



public class Client {

	public static void main(String[] args) {
		new DrawMoney().process();
		//采用匿名内部类
		BankTemplateMethod bankefulei = new BankTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("我要取钱1亿");
				
			}
		};
		bankefulei.process();

	}

}
class DrawMoney  extends BankTemplateMethod{
	
	@Override
	public void transact() {
		System.out.println("我要存钱10亿");
	}
	
}