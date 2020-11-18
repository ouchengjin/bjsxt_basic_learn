package com.bjsxt.iterator;

public class Client {

	public static void main(String[] args) {
		ConcreteMyAggregate concreteMyAggregate = new ConcreteMyAggregate();
		concreteMyAggregate.addObject("aa");
		concreteMyAggregate.addObject("bb");
		concreteMyAggregate.addObject("cc");
		concreteMyAggregate.addObject("dd");
		MyIterator creatIterator = concreteMyAggregate.creatIterator();
		while(creatIterator.hasNext()) {
			System.out.println(creatIterator.getCurrentObj());
			creatIterator.next();
		}
	}

}
