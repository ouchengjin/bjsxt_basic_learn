package com.bjsxt.test;
@Author(name="ouchengjin",year=2020)
public class Emp {
	private int empNo;
	private String empName;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Emp(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}
	
	public void sayHello(int a) {
		System.out.println("sayHello,"+a);
	}
	

}
