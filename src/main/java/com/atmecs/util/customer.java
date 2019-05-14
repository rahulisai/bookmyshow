package com.atmecs.util;

public class customer {
	double id;
	String name;
	String lname;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", lname=" + lname + "]";
	}
	
}
