package com.qimh.action;

import com.opensymphony.xwork2.ActionSupport;

public class ConversionAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	
	public String execute(){
		
		System.out.println("execute.....");
		System.out.println("age="+age);
		return "success";
	}

}
