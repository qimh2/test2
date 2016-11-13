package com.qimh.entity;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
	
	
	
	//无参构造方法
	public Employee(){
		
	}
	
	//有参构造方法
	public Employee(int employeeId, String firstName, String lastName,String email) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}





	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	
	

}
