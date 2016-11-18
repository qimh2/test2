package com.qimh.model;

import java.util.Date;

public class Manager {
	
	private String name;
	private Date brith;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	@Override
	public String toString() {
		return "Manager [name=" + name + ", brith=" + brith + "]";
	}
	
	
	
	

}
