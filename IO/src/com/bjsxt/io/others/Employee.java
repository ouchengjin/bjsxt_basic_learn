package com.bjsxt.io.others;
/**
 * 空接口只是一个标识，标识可以序列化
 * @ClassName: Employee
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-02 22:27:23
 */
public class Employee implements java.io.Serializable {
	//不需要序列化，不会被序列化进去
	private transient String name;
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


}
