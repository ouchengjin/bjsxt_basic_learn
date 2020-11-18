package com.bjsxt.mediator;

public class Development implements Department {
	private Mediator mediator;//持有中介者的引用
	public Development() {
	}
	public Development(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.registor("Development", this);
	}

	@Override
	public void selfAction() {
		System.out.println("开发软件");
	}

	@Override
	public void outAction() {
		System.out.println("开发需要钱");
		mediator.command("Finacial");;
	}

}
