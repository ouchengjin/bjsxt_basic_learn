package com.bjsxt.proxy.staticProxy;

public class Client {

	public static void main(String[] args) {
		ProxyStar proxyStar = new ProxyStar(new RealStar());
		proxyStar.confer();
		proxyStar.signContract();
		proxyStar.bookTicket();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
