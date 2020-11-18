package com.bjsxt.memento;
/**
 * 源发器类
 * @ClassName: Emp
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-10 21:40:54
 */
public class Emp {
	private String name;
	private int  age;
	private double salary;
	public Emp(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	//进行备忘操作，返回备忘录对象
	public EmpMemento memento(){
		return new EmpMemento(this);
	}
	//进行数据恢复。恢复成备忘录对象的值
	public void recovery(EmpMemento empMemento) {
		this.name = empMemento.getName();
		this.age = empMemento.getAge();
		this.salary = empMemento.getSalary();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
