package com.qimh.action;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.qimh.model.Manager;

public class TestCollentionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Collection<Manager> managers = null;
	
	public void setManagers(Collection<Manager> managers) {
		this.managers = managers;
	}
	
	public Collection<Manager> getManagers() {
		return managers;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute.....");
		System.out.println(managers);
		return SUCCESS;
	}

	
}
