package com.bjsxt.bridge;
/**
 * 电脑类型的维度
 * @ClassName: Computer2
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-03 23:13:11
 */
public class Computer2 {
	private Brand brand;

	public Computer2(Brand brand) {
		super();
		this.brand = brand;
	}
	
	void sale() {
		brand.sale();
	}
	
}
class Desktop2 extends Computer2{
	public Desktop2(Brand brand) {
		super(brand);
	}
	@Override
	void sale() {
		super.sale();
		System.out.println("Desktop2.sale()");
	}
	
}
class Laptop2 extends Computer2{
	public Laptop2(Brand brand) {
		super(brand);
	}
	@Override
	void sale() {
		super.sale();
		System.out.println("Laptop2.sale()");
	}
	
}
class Pad2 extends Computer2{
	public Pad2(Brand brand) {
		super(brand);
	}
	@Override
	void sale() {
		super.sale();
		System.out.println("Pad2.sale()");
	}
	
}