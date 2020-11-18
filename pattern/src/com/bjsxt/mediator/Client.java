package com.bjsxt.mediator;

public class Client {

	public static void main(String[] args) {
		Mediator president = new President();
		Department finacial = new Finacial(president);
		Department development = new Development(president);
		development.selfAction();
		development.outAction();
		finacial.outAction();
	}

}
