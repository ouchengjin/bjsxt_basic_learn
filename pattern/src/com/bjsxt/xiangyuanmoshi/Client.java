package com.bjsxt.xiangyuanmoshi;

public class Client {

	public static void main(String[] args) {
		Weiqiinterface weiqiinterface = factory.getWeiqiinterface("black");
		Weiqiinterface weiqiinterface2 = factory.getWeiqiinterface("black");
		Weiqiinterface weiqiinterface3 = factory.getWeiqiinterface("red");
		System.out.println(weiqiinterface);
		System.out.println(weiqiinterface2);
		System.out.println(weiqiinterface3);
		//增加对外部状态的处理
		weiqiinterface.disPlay(new QiziZuobiao(10, 20));
		weiqiinterface2.disPlay(new QiziZuobiao(100, 200));
		weiqiinterface3.disPlay(new QiziZuobiao(1000, 2000));
		

	}

}
