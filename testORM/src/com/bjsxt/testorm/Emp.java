package com.bjsxt.testorm;

import java.sql.Date;

public class Emp {//表结构和类对应
	//最好使用包装类
	private Integer id;
	private String empname;
	private double salary;
	private Date birthday;
	private Integer age;
	private Integer depId;
	public Emp() {
	}
	
	public Emp(String empname, double salary, Integer age) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
	}

	public Emp(String empname, double salary, Date birthday, Integer age, Integer depId) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
		this.depId = depId;
	}

	public Emp(Integer id, String empname, double salary, Date birthday, Integer age, Integer depId) {
		super();
		this.id = id;
		this.empname = empname;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
		this.depId = depId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	
	

}
