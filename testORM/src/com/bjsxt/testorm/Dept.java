package com.bjsxt.testorm;

public class Dept {
	private Integer id;
	private String dname;
	private Integer address;
	public Dept(Integer id, String dname, Integer address) {
		super();
		this.id = id;
		this.dname = dname;
		this.address = address;
	}
	
	
	public Dept(String dname, Integer address) {
		super();
		this.dname = dname;
		this.address = address;
	}


	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

}
