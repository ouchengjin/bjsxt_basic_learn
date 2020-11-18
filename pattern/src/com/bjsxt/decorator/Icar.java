package com.bjsxt.decorator;
//抽象构建
public interface Icar {
	void move();
}
//具体构建角色（真实对象）
class Car implements Icar{

	@Override
	public void move() {
		System.out.println("run on the land");
		
	}
}
//装饰角色
class SuperCar implements Icar{
	private Icar car;
	public SuperCar() {
	}
	public SuperCar(Icar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}
//具体装饰角色
class SwimCar extends SuperCar{
	public SwimCar() {
	}
	public SwimCar(Icar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		System.out.println("car run in the water");
	}
}
class FlyCar extends SuperCar{
	public FlyCar() {
	}
	public FlyCar(Icar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		System.out.println("car fly in the sky");
	}
}

class AiCar extends SuperCar{
	public AiCar() {
	}
	public AiCar(Icar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		System.out.println("car can AI");
	}
}





	