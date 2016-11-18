package com.qimh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qimh.model.Department;

public class TestComplexPropertyAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute.....");
		System.out.println(department);
		return SUCCESS;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		this.department = new Department();
		return this.department;
	}
}
