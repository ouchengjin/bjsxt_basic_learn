package com.bjsxt.mediator;

public class Finacial implements Department {
	private Mediator mediator;//持有中介者的引用
	public Finacial() {
	}
	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.registor("Finacial", this);
	}
	@Override
	public void selfAction() {
		System.out.println("数钱");

	}

	@Override
	public void outAction() {
		System.out.println("需要开发部门支持");
		mediator.command("Development");
	}

}
